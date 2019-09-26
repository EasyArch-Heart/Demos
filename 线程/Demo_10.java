package Demos.file.线程;

import java.util.concurrent.Semaphore;

/*
Semaphore控制并发量的工具
    即同时进行此工作的线程数不超过预设的数值

 */
public class Demo_10 {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<20;i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(getName() + "正在运行");
                        Thread.sleep(1000);
                        semaphore.release();
                        System.out.println("还有可用数" + semaphore.availablePermits());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
