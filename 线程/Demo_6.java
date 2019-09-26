package Demos.file.线程;
/*读写锁  多个读可以并发
  读与写不能并发
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

 class Context {
    ReadWriteLock lock =new ReentrantReadWriteLock();//读写锁
    Lock read=lock.readLock();
    Lock write=lock.writeLock();
    public  void read(){
        read.lock();                            //上锁
        System.out.println("正在读取数据.......");
        try {
            Thread.sleep(5000);
            System.out.println("读取完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        read.unlock();                         //读完放锁
    }
    public void write(){
        write.lock();
        System.out.println("正在修改.........");
        try {
            Thread.sleep(7000);
            System.out.println("修改完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        write.unlock();
    }
}

class doit extends Thread{
    boolean isread;
    Context context;
    public doit(Context context, boolean isread){
        this.isread=isread;
        this.context=context;
    }

    @Override
    public void run() {
        if(isread)
            context.read();
        else
            context.write();
    }
}

public class Demo_6 {


    public static void main(String[] args) {
//        Context c=new Context();
//        doit do1=new doit(c,false);
//        doit do2=new doit(c,true);
//        do1.start();
//        do2.start();
        Context c=new Context();
        doit do1=new doit(c,true);
        doit do2=new doit(c,true);
        do1.start();
        do2.start();
    }
}
