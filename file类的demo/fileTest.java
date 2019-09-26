package Demos.file.file类的demo;

import java.io.*;

public class fileTest {
    public static void main(String[] args) {
        File file=new File("/home/devil/Desktop");
        String [] list=file.list();//返回值是字符串
        for(String name:list){
            System.out.println(name);
        }
    }
}
