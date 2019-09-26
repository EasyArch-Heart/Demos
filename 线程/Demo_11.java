package Demos.file.线程;
/*
守护线程
    Daemon Thread
    用个比较通俗的比如，任何一个守护线程都是整个JVM中所有非守护线程的保姆：
    只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；
    只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作。
 */
public class Demo_11 {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("我是守护线程  " + isDaemon());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("非守护线程结束,守护线程也结束");
    }
}
