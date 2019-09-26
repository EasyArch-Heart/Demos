package Demos.file.线程;

import org.apache.commons.collections.collection.SynchronizedCollection;

/*死锁
一下例子概述:
    a类有f1,f2方法
    b类有f3,f4方法
    a类的f1方法有锁,方法体中调用b类的f4方法,f4方法需要锁
    而b类的f3方法有锁,方法体中调用a类的f2方法
    导致调用a类的f1方法时a类实例上锁,b类方法不能继续(f2方法需要锁此时a类锁还未归还),而b类实例也上锁,导致a类方法不能继续,形成死锁(你在等我,而我在等你)
 */
class A {
    B b;
    public synchronized void f1(B b){
        System.out.println("开始调用b的f4方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.f4();
    }
    public synchronized void f2(){
        System.out.println("A的f2方法");
    }
}

class B {
    A a;
    public synchronized void f3(A a){
        System.out.println("开始调用a的f2方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.f2();
    }
    public synchronized void f4(){
        System.out.println("B的f4方法");
    }
}

class DeadLock implements Runnable {
    A a = new A();// 1 2
    B b = new B();// 3 4

    public void init() {
        Thread.currentThread().setName("主线程");
        // 调用a对象的foo方法
        a.f1(b);//a 1  b 4
        System.out.println("进入了主线程之后");
    }

    public void run() {
        Thread.currentThread().setName("副线程");
        // 调用b对象的bar方法
        b.f3(a);//b 4 a 1
        System.out.println("进入了副线程之后");
    }
}

public class Demo_7 {
    public static void main(String[] args) {
        DeadLock deadLock=new DeadLock();
        new Thread(deadLock).start();
        deadLock.init();
    }

}

