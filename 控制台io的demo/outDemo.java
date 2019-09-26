package Demos.file.控制台io的demo;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class outDemo {
    public static void main(String[] args) {
        PrintWriter writer =new PrintWriter(System.out);//将System.out当做文件,实则是控制台的输出
        writer.print("haha");//PrintWriter的print每执行完一次自动调用flush()方法
        writer.close();
    }
}
