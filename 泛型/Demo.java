package Demos.file.泛型;

public class Demo<T> {
    //静态变量,方法不能使用泛型
    //static T in;错的
    public T age;
    public T getAge(){
        return this.age;
    }
    public void setAge(T age){
        this.age=age;
    }
}
