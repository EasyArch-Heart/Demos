package Demos.file.io的demo;

import java.io.*;

public class fileInputTest {
    public static void main(String[] args) {
        File file=new File("/home/devil/Desktop/FirstDemo.txt");
        FileInputStream in= null;
        try {
            in = new FileInputStream(file);
            byte[]context=new byte[101];
            int i;
            while ((i=in.read(context))>0){
                System.out.println(new String(context,0,i, "UTF-8"));//将i的范围体现出来就不会出现还有字符串中有空的
                System.out.println("wo");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
