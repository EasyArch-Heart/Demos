package Demos.file.线程;
/*
 * notify等的多线程Demo
 */
class Task_ extends Thread{
    Object obj;
    public Task_(Object obj,String name) {
        super(name);
        this.obj=obj;
    }
    public void run() {
        System.out.println(getName()+"-启动");
        synchronized (obj){
            System.out.println(getName()+"-释放锁进入阻塞.....");
            try {
                obj.wait();
                System.out.println(getName()+"-被唤醒!");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
        }
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(obj){
                System.out.println(getName()+"-唤醒其他阻塞线程!");
                obj.notifyAll();
                System.out.println(getName()+"-唤醒结束,线程结束");
        }
    }
}

class Task1 extends Thread{
    Object obj;
    public Task1(Object obj,String name) {
        super(name);
        this.obj=obj;
    }
    public void run() {
        System.out.println(getName()+"-启动");
        try {
            sleep(3000);
            synchronized(obj) {
                obj.notifyAll();
                System.out.println(getName()+"唤醒其他阻塞线程");

            }
            System.out.println(getName()+"-释放锁进入阻塞.....");
            synchronized(obj){
                try {
                    obj.wait();
                    System.out.println(getName()+"-被唤醒!");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}

public class Demo_17 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object obj="";
        Task_ t1=new Task_ (obj,"a线程 ");
        Task1 t2=new Task1(obj,"b线程 ");
        t1.start();
        t2.start();
//		try {
//			Thread.sleep(10000);
//			synchronized(obj) {
//				System.out.println(Thread.currentThread().getName()+"-唤醒b线程");
//				obj.notify();
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

}