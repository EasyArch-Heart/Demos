package Demos.file.线程;
/*
 定义自己的异常处理器
 用来处理线程未被处理的错误
 */
class MyExHandler implements Thread.UncaughtExceptionHandler {
    // 实现uncaughtException方法，该方法将处理线程的未处理异常
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常：" + e);
    }
}

public class ExHandler {
    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler
                (new MyExHandler());
        /*上述句子拆分
        Thread.currentThread()当前线程
        .setUncaughtExceptionHandler 设置错误处理器
                (new MyExHandler());将自定义的处理器传入
         */
        int a = 5 / 0;
        System.out.println("aaaaa程序正常结束！");
    }
}
