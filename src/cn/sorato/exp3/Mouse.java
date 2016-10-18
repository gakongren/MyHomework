package cn.sorato.exp3;

public class Mouse extends Rodent{
    @Override
    void eatNuts(){
        weight++;
        System.out.println("Mouse FAT+1");
    }

}
