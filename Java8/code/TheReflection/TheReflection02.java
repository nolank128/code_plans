package TheReflection;

import org.junit.Test;

public class TheReflection02 {
    @Test
    public void  test1(){
        A a  = new A();
        System.out.println(A.m);
    }
}
class A{
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;

    public A(){
        System.out.println("A类的无参构造初始化");
    }
}
