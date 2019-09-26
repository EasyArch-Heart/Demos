package Demos.file.泛型;

public class Demo_1 extends Demo<String> {
//    public void setAge(String age){
//        this.age=age;
//    }
//    public String getAge(){//既然泛型为String则此处的返回值T也只能是String 换成其他报错
//        return this.age;
//    }
//也可以直接使用上面只是继承String泛型后两方法的样子
    public Demo_1(){}
    public Demo_1(String age){
        this.age=age;
    }
    public static void main(String[] args) {
        Demo_1 demo_1=new Demo_1();
        demo_1.setAge("1");
        System.out.println(demo_1.getAge());
    }
}
