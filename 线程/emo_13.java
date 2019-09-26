package Demos.file.线程;

import java.util.Random;

/*
ThreadLocal变量
    每个线程都可以独立出自己的实例副本即一个变量名在每个线程中是不同实例
    以下是其中一次的运行结果
    Thread-0	0
    Thread-0	1
    Thread-1	0
    Thread-0	2
    Thread-1	1
    Thread-1	2
    说明线程1与线程2的threadlocal变量不是同一个
 */
public class emo_13 {
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) {
        Thread  t=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    try {
                        threadLocal.set(i);
                        sleep(1*new Random().nextInt(2000));
                        System.out.println(Thread.currentThread().getName() + '\t' +threadLocal.get() );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread  t1=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    try {
                        threadLocal.set(i);
                        sleep(1*new Random().nextInt(2000));
                        System.out.println(Thread.currentThread().getName() + '\t' +threadLocal.get() );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        t1.start();
    }
}
