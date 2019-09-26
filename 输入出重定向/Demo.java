package Demos.file.输入出重定向;

import java.io.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        FileInputStream reader= null;
        try {
            reader = new FileInputStream("/home/devil/Desktop/FirstDemo.txt");
            System.setIn(reader);//reader必须是InputStream类的
            Scanner in=new Scanner(System.in);//将System.in输入的内容保存于此
            in.useDelimiter("\n");//修改分隔符以\n来分割随机读写文件
            String str=null;
            while (in.hasNext()){
                System.out.println(str=in.next());
            }
            PrintStream out=new PrintStream(new FileOutputStream("/home/devil/Desktop/FirstDemo.txt",true));
            System.setOut(out);//out必须事printStream类的
            System.out.println("追加的内容哈哈");

        } catch (Exception e) {
            System.out.println("完了");
            e.printStackTrace();
        }
    }
}
