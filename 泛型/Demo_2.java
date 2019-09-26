package Demos.file.泛型;

public class Demo_2 extends Demo {//不指定泛型也可以 T默认为Object
    public static void main(String[] args) {
        Demo_2 demo_2=new Demo_2();
        demo_2.setAge("1");
        System.out.println(demo_2.getAge());
    }
}
