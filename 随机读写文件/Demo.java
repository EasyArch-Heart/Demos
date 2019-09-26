package Demos.file.随机读写文件;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo {
    public static void main(String[] args) {
        try {
            RandomAccessFile file=new RandomAccessFile("/home/devil/Desktop/FirstDemo.txt","rw");
            file.seek(10);//跳多少个字节
            byte[] words=new byte[1000];
            int hasread;
            while((hasread=file.read(words))>0){
                System.out.println(new String(words, 0, hasread));
            }
            file.seek(file.length());
            file.write("我是你爸爸\n".getBytes());
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
