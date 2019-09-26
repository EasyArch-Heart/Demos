package Demos.file.线程;
/*
此例为ForkJoinPool的实战例子,把读文件的任务碎片化
 */

import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class ReadTask extends RecursiveTask<String> {
    int beg;
    int end;
    File file;
    public ReadTask (int beg,int end,File f){
        this.beg=beg;
        this.end=end;
        this.file=file;
    }
    @Override
    protected String compute() {
        if((end-beg)>1){
            int mid=(end+beg)/2;
            ReadTask t1=new ReadTask(beg,mid,file);
            ReadTask t2=new ReadTask(beg,mid,file);
            invokeAll(t1,t2);
            try {
                return t1.get()+t2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }else {
            return Read(file,beg);
        }
        return null;
    }

    private String Read(File file,int beg){
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            for(int i=1;;i++){
                String str= reader.readLine();
                if(i%beg==0){
                    return str;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class Demo_16 {
    public static void main(String[] args) {
        File file=new File("/home/devil/Desktop/FirstDemo.txt");
        ForkJioinPool f=new ForkJoinPool();
    }
}
