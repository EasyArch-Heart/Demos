package Demos.file.线程;
/*
栅栏锁
    闭锁的升级版 可以多次使用,当要拦截的线程调用awai()方法时,如果此线程到达栅栏锁的屏障点,就会等待其他线程
    当所有线程都到达了即栅栏锁的计数器减为0,则释放所有线程
 */

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Runner implements Runnable{

    private CyclicBarrier cb;
    private String name;
    public Runner(CyclicBarrier cb,String name){
        this.cb=cb;
        this.name=name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000*(new Random()).nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "准备好啦");
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"出发");
    }
}

public class Demo_8 {
    public static void main(String[] args) {
        CyclicBarrier cb=new CyclicBarrier(3);
        new Thread(new Runner(cb,"1")).start();
        new Thread(new Runner(cb,"2")).start();
        new Thread(new Runner(cb,"3")).start();
        System.out.println("比赛开始");
    }
}
