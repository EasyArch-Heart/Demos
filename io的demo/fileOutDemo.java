package Demos.file.io的demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileOutDemo {
    public static void main(String[] args) {
        File file=new File("/home/devil/Desktop/FirstDemo.txt");
        try {
            FileOutputStream out=new FileOutputStream(file,true);
            out.write("hah".getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
