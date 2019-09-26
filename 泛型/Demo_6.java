package Demos.file.泛型;
//更正泛型关于静态的使用方法
public class Demo_6 <T>{
    //public static T a; 此种不行
    //不能给静态方法传泛型类参数如下
    //public static void test(T t){}
    //但可以指定静态方法的返回值是泛型如
    //public static <A> A test2(){ } 正确
    //public static T test3(){} 错误
    private T infor;

    public T getInfor() {
        return infor;
    }

    public void setInfor(T infor) {
        this.infor = infor;
    }
    public static <T> T get(Object a){//可以这么用
        T b=null;
        b=(T) a;
        return b;
    }

    public static void main(String[] args) {
        Demo_6 <String> demo_6=new Demo_6<>();
        demo_6.setInfor("xxx");
        System.out.println(demo_6.getInfor());
        String str=Demo_6.get("yyy");
        System.out.println(str);
    }
}
