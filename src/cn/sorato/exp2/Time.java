package cn.sorato.exp2;

/**
 * Created by kongren on 2016/10/10.
 */
public class Time{
    private long h, m, s;

    public Time(long hour, long minute, long second){
        h = hour;
        m = minute;
        s = second;
    }

    public String display(){
        return this.toString();
    }

    public void addSecond(int s){
        this.s += s;
    }

    public void addMinute(int m){
        this.m += m;
    }

    public void addHour(int h){
        this.h += h;
    }

    public void subSecond(int s){
        this.s -= s;
    }

    public void subMinute(int m){
        this.m -= m;
    }

    public void subHour(int h){
        this.h -= h;
    }

    private void plusOneSec(){
        System.out.println("续一秒");
        s += 1;
    }

    @Override
    public String toString(){
        return h + ":" + m + ";" + s;
    }
}
