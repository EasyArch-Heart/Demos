package Demos.file.io的demo;

import java.io.*;

public class fileReaderDemo {
    public static void main(String[] args) {
        File file=new File("/home/devil/Desktop/FirstDemo.txt");
        FileReader reader= null;
        try {
            reader = new FileReader(file);
            BufferedReader reader1=new BufferedReader(reader);
            String line=null;
            while ((line=reader1.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
