package Demos.file.泛型;

import java.util.ArrayList;
import java.util.List;

//集合框架的泛型
public class Demo_7 {
    public static void main(String[] args) {
        List<Number>list=null;
        List<Integer>list1=new ArrayList<>();
        //list=list1;泛型没有继承关系,这种写法错误
    }
}
