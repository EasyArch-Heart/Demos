package Demos.file.线程;
/*
线程的yield()方法
当线程执行了此方法之后,此线程主动出让cpu,将自己降级为"就绪状态",
值得注意的是 出让cpu后并不意味着将cpu让给其他同级的线程,而是通过竞争,所以结果要么是其他同级的线程抢到了并执行
要么就是此线程又抢到了并执行,
下面是个小Demo
 */

class JoinThreadTest extends Thread{
    public JoinThreadTest(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i=0;i<50;i++) {
            System.out.println(getName() + "号线程执行");
            if (i == 25){
                yield();
                System.out.println(getName() + "号线程出让!");
            }
        }
    }
}
class JoinThreadTest_1 extends Thread{
    public JoinThreadTest_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(getName()+"号线程执行");
        }
    }
}
public class Demo_4 {
    public static void main(String[] args) {
        JoinThreadTest t1=new JoinThreadTest("1");
        JoinThreadTest_1 t2=new JoinThreadTest_1("2");
        JoinThreadTest_1 t3=new JoinThreadTest_1("3");
        JoinThreadTest_1 t4=new JoinThreadTest_1("4");
        JoinThreadTest_1 t5=new JoinThreadTest_1("5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
//似乎执行结果并看不出个卵蛋