package Demos.file.线程;
/*
java 同步块 synchronized (对象){}
    java同步块是同步在一个对象基础上的,即一个线程操作此对象,另一个线程进入阻塞直到此线程操作完毕
 */


public class Demo_9 {
    static  Object obj=new Object();
    public static void main(String[] args) {
        Thread thread= new Thread(() -> {
            try {
                System.out.println("等待");
                Thread.sleep(1000);
                synchronized (obj){
                    obj.wait();
                    System.out.println("唤醒了1");
                }
//                obj.wait();
                System.out.println("唤醒了2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("111");
        synchronized (obj){
            System.out.println("唤醒");
            obj.notifyAll();
            System.out.println("ok");
        }
        System.out.println("222");

    }
}
