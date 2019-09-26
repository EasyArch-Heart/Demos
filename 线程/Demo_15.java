package Demos.file.线程;
/*
此为RecusiveTask(有返回值)的demo
    其最终返回值是各个compute方法返回值的总和
此demo为计算加法的demo
 */

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class returnTask extends RecursiveTask<Integer> {
    int beg;
    int end;
    String a[];
    public returnTask(int beg,int end,String a[]){
        this.a=a;
        this.beg=beg;
        this.end=end;
    }
    @Override
    protected Integer compute() {
        if(end-beg>1){
            int mid=(end+beg)/2;
            returnTask t_1=new returnTask(beg,mid,a);
            returnTask t_2=new returnTask(mid,end,a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            invokeAll(t_1,t_2);
            try {
                return t_1.get()+t_2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }else {
            return job(beg);
        }
        return 0;
    }

    private int job(int i){
        String na[]=a[i].split(" ");
         return add(Integer.parseInt(na[0]),Integer.parseInt(na[2]));
    }

    private int add(int a,int b){
        return a+b;
    }
}

public class Demo_15 {
    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String str=in.nextLine();
        String str="1 + 2-2 + 3-3 + 4";
        System.out.println(str);
        String context[];
        context=str.split("-");
        returnTask t=new returnTask(0,3,context);

        ForkJoinPool pool=new ForkJoinPool();
        int sum=pool.invoke(t);
        System.out.println("总和为 " + sum);
    }
}
