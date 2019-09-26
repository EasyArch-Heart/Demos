package Demos.file.线程;
//join()方法,如 t.join()是主线程进入等待,等到t线程执行完了,才能继续执行主线程,而此时不影响其他线程

//下述线程是待会join的线程
class thread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("新线程在执行");
        }
    }
}

//此线程是检验是否受上述线程join()的影像
class thread_1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("另一个线程不受join()影响还在执行");
        }
    }
}


public class Demo_2 {
    public static void main(String[] args) {
        thread t1=new thread();
        thread_1 t2=new thread_1();
        t2.start();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }
}
