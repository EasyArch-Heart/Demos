package Demos.file.线程;
//线程优先级
//jvm并不会严格按照线程的优先级来执行线程,线程的优先级只不过是高优先级的线程大概率的先执行

class Thread_My extends Thread{
    public Thread_My(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i=0;i<50;i++){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(getName() + "的优先级 " + getPriority());
        }
    }
}

public class Demo_3 {
    public static void main(String[] args) {
        Thread_My t1=new Thread_My("第一个线程");
        Thread_My t2=new Thread_My("第二个线程");
        t1.start();
        t2.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
    }

}
