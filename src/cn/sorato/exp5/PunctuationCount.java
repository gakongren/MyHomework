package cn.sorato.exp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PunctuationCount{
    volatile private long count = -1;
    BufferedReader reader;
    private ThreadLocal<Thread> tl = new ThreadLocal<>();

    public PunctuationCount(BufferedReader reader){
        this.reader = reader;
    }

    public static boolean isPunctuation(char c){
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if(ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS){
            return true;
        }else{
            return false;
        }
    }

    public void multiThreadCound(){
        count = 0;
        try{
            String line = reader.readLine();
            List<FutureTask<Long>> ftlist = new ArrayList<>();
            while(line != null){
                String tmp = line;
                FutureTask<Long> ft = new FutureTask<>(()->countLinePunc(tmp));
                ftlist.add(ft);
                new Thread(ft).start();
                line = reader.readLine();
            }
            ftlist.forEach(ft->{
                try{
                    count += ft.get();
                }catch(InterruptedException | ExecutionException e){
                    e.printStackTrace();
                }
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void streamCount(){
        List<String> list = new ArrayList<>();
        try{
            String line = reader.readLine();
            while(line != null){
                list.add(line);
                line = reader.readLine();
            }
            count = list.parallelStream()
                    .flatMap(s->s.chars().mapToObj(i->(char) i))
                    .filter(PunctuationCount::isPunctuation)
                    .count();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void count(){
        count = 0;
        try{
            String line = reader.readLine();
            while(line != null){
                count += countLinePunc(line);
                line = reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private long countLinePunc(String line){
        long num = 0;
        for(int i = 0; i < line.length(); i++){
            if(isPunctuation(line.charAt(i))){
                num++;
            }
        }
        return num;
    }

    public long getPuncCount(){
        return count;
    }

}
