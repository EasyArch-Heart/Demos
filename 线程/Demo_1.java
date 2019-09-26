package Demos.file.线程;
/*基础
两种多线程方法
1. 继承Thread类
2. 实现Runnable借口
 */
class MyThread extends Thread{
    public MyThread(String name){super(name);}

    @Override
    public void run() {
        System.out.println(this.getName());
    }
}

class MyThread_1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Demo_1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new MyThread("aaa").start();
        new MyThread("bbb").start();
        MyThread_1 thread_1=new MyThread_1();
        new Thread(thread_1,"ccc").start();
    }
}
