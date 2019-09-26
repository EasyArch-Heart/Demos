package Demos.file.线程;
/*
    线程池
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo_12 {
    public static void main(String[] args) {
        /*
        ScheduledThreadPool线程池可以定时执行任务
         */
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
//        Runnable task = new Runnable() {
//            public void run() {
//                System.out.println("HeartBeat.........................");
//            }
//        };
//        executor.scheduleAtFixedRate(task,5,3, TimeUnit.SECONDS);
        //5秒后第一次执行，之后每隔3秒执行一次


        /*
        CachedThreadPool线程池可以重用空闲的线程
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();//线程池里面的线程数会动态变化，并可在线程线被移除前重用
        for (int i = 1; i <= 3; i ++) {
            final  int task_1 = i;   //10个任务
            try {
                TimeUnit.SECONDS.sleep(1);  //加上这句话就体现出来重用了,因为在新线程建立时先看有没有空闲的线程,
            } catch (InterruptedException e) {        //发现有线程执行完命令了在60秒内就能重用就重用
                e.printStackTrace();
            }

            threadPool.execute(new Runnable() {    //接受一个Runnable实例
                public void run() {
                    System.out.println("线程名字： " + Thread.currentThread().getName() +  "  任务名为： "+task_1);
                }
            });
        }
        threadPool.shutdown();//showdown方法如果还有以前提交的任务没完成先完成再关闭
    }
}
