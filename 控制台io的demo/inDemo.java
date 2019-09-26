package Demos.file.控制台io的demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class inDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);//in是控制台的流
        BufferedReader reader=new BufferedReader(in);//如果直接用in的read()读的char数组变为String
                                                    //则if语句过不了equals方法为false
        String line;
        while ((line=reader.readLine())!=null){
            if(line.equals("exit"))
                System.exit(0);
            else
                System.out.println("输入的是" + line);
        }
    }
}
