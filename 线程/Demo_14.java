package Demos.file.线程;
/*
ForkJoinPool的例子
    ForkJoinPool来支持将一个任务拆分成多个“小任务”并行计算，再把多个“小任务”的结果合并成总的计算结果
    是一种特殊的线程池
    此池子有一种工作窃取算法,当一个队列的任务完了后会从其他队列的末尾拿任务来执行
    其中ForkJoinTask代表一个可以并行、合并的任务。ForkJoinTask是一个抽象类，
    它还有两个抽象子类：RecusiveAction和RecusiveTask。
    其中RecusiveTask代表有返回值的任务，而RecusiveAction代表没有返回值的任务

    此例子是RecusiveAction(无返回结果)的demo
    此例子的实现原理是:
        compute中的代码
        当任务的start与end的差大于预设的阈值,则执行if语句的代码,即将此大任务切成两个小任务
        否则就执行else内容循环使数组加1,每个任务的循环体执行次数为自身的end-start,
        所以最终结果不会有加多的现象
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Task extends RecursiveAction{
    int start;
    int end;
    int a[];

    public Task (int start,int end,int a[]){
        this.a=a;
        this.end=end;
        this.start=start;
    }

    @Override
    protected void compute() {
        if((end-start)>20){
            int mid=(start+end)/2;
            Task t_1=new Task(start,mid,a);
            Task t_2=new Task(mid,end,a);
            invokeAll(t_1,t_2);
        }else {
            for(int i=start;i<end;i++){
                a[i]+=1;
            }
        }
    }
}


public class Demo_14 {
    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        int a[]=new int[80];
        for(int i=0;i<80;i++){
            a[i]=i;
        }
        Task t=new Task(0,80,a);
        for(int i=0;i<80;i++){
            System.out.print(a[i] + "\t");
        }
        pool.invoke(t);
        System.out.print("\n");
        for(int i=0;i<80;i++){
            System.out.print(a[i] + "\t");
        }
    }
}
