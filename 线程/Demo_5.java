package Demos.file.线程;
/*
闭锁
调用await方法的线程得等 闭锁数字减少到0才能继续执行
而且这是一次性的,再一次用就不行了
 */

import java.util.concurrent.CountDownLatch;

class myThread extends Thread{
    public CountDownLatch cdl;
    public myThread (String name,CountDownLatch cdl ){
        super(name);
        this.cdl=cdl;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "线程准备好啦");
        cdl.countDown();
    }
}

public class Demo_5 {
    public static void main(String[] args) {
        CountDownLatch cdl=new CountDownLatch(3);
        myThread t1=new myThread("a",cdl);
        myThread t2=new myThread("b",cdl);
        myThread t3=new myThread("c",cdl);
        t1.start();
        t2.start();
        t3.start();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("栅栏开启");
    }
}
