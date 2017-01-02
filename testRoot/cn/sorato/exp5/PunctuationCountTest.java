package cn.sorato.exp5;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by kongren on 2017/1/2.
 */
public class PunctuationCountTest{
    PunctuationCount counter;
    static final String FILE_NAME = "testResource/白夜行.txt";

    @Before
    public void setup() throws FileNotFoundException{
        BufferedReader reader = null;
        FileReader fr = new FileReader(new File(FILE_NAME));
        reader = new BufferedReader(fr);
        counter = new PunctuationCount(reader);
    }
    @Test
    public void test() throws InterruptedException{
        counter.multiThreadCound();
        System.out.println("标点符号共有 "+counter.getPuncCount()+"个");
    }

}