package cn.sorato.exp2;

/**
 * Created by kongren on 2016/10/10.
 */
public class Time{
    private int h = 0, m = 0, s = 0;

    public Time(int hour, int minute, int second){
        addHour(hour);
        addMinute(minute);
        addSecond(second);
    }

    public String display(){
        return this.toString();
    }

    public void addSecond(int s){
        this.s += s;
        if(this.s >= 60){
            this.s -= 60;
            addMinute(1);
        }
    }

    public void addMinute(int m){
        this.m += m;
        if(this.m >= 60){
            this.m -= 60;
            addHour(1);
        }
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
