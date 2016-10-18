package cn.sorato.exp3;

public class Hamster extends Rodent{

    @Override
    void eatNuts(){
        weight += 3;
        System.out.println("RODENT FAT+3");
    }

}
