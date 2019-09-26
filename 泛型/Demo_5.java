package Demos.file.泛型;
//指定多个泛型
public class Demo_5<A,B,C> {
    public<D> Demo_5 (A a,B b,C c,D d){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
    public <T> void print(T t){
        System.out.println(t);
    }
    public static void main(String[] args) {
        Demo_5 <String,String,String>demo_5=new Demo_5<String, String, String>("1","2","3",4);
        demo_5.print("5454");
    }
}
