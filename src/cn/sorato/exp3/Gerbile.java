package cn.sorato.exp3;

public class Gerbile extends Rodent{

    @Override
    void eatNuts(){
        weight += 2;
        System.out.println("GERBILE FAT+2");
    }

}
