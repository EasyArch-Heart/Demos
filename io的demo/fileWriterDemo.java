package Demos.file.io的demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileWriterDemo {
    public static void main(String[] args) {
        File file =new File("/home/devil/Desktop/FirstDemo.txt");
        try {
            FileWriter writer=new FileWriter(file,true);//是否追加
            writer.write("heihei");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
