package Demos.file.泛型.通配符;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public void print2(List<? super Integer> list){}//指定是Integer或其父类
    public void print1(List<?extends Number> list){//一般用来传参数即第15行,可以匹配Number及子类的List

    }
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<Number>list1=new ArrayList<>();
        Integer a=1;
//        list.add(new Integer(1));//此种写法事错误的,通配符不允许添加元素只能去出T类型
        Demo demo=new Demo();
        demo.print1(list);
        demo.print2(list1);
    }
}
