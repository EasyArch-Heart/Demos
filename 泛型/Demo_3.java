package Demos.file.泛型;

public class Demo_3 <T extends Demo> {//指定T是Demo的子类
    public T infor;
    public void setInfor(T infor){
        this.infor=infor;
    }
    public T getInfor(){
        return this.infor;
    }
    public static void main(String[] args) {
        Demo_3 demo_3=new Demo_3();
        demo_3.setInfor(new Demo_1("1"));
        System.out.println(demo_3.getInfor().age);
    }

}
