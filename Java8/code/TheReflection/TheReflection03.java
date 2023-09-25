package TheReflection;

import org.junit.Test;

public class TheReflection03 {
    //测试类什么时候会初始化
   static {
        System.out.println("Main方法被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();
        //2.反射也会主动引用
        //Class.forName("TheReflection.Son");

        //不会产生类的引用的方法
        //System.out.println(Son.b);//子类引用父类的静态变量，不会导致子类初始化

        //数组名只是一个地址
        //Son[] arr = new Son[5];

        //常量不会引起父类或子类的初始化，它们都在常量池里，早在链接阶段就存入调用类的常量池中    了
        System.out.println(Son.M);
    }
}
class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{

    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}

