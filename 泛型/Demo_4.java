package Demos.file.泛型;

public class Demo_4 {
    public <T>Demo_4(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        Demo_4 demo_4=new Demo_4("aaa");//这种写法可以
        Demo_4 demo_41=new <String> Demo_4("bbb");//两种等价
    }
}
