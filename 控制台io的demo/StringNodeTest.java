package Demos.file.控制台io的demo;

import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
    public static void main(String[] args) {
        String str="这是字符串,要改成字符流";
        StringReader reader=new StringReader(str);
        char[] words=new char[100];
        int hasread;
        try {
            while ((hasread=reader.read(words))>0){
                System.out.println(new String(words, 0, hasread));
            }
            StringWriter writer=new StringWriter();//内部是Stringbuffer
            writer.write("first\n");
            writer.write("second\n");
            System.out.println("内容如下");
            System.out.println(writer.toString());//重写了toString()方法,输出内容
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
