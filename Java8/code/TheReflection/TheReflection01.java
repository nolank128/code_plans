package TheReflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.sql.SQLOutput;

/**
 * 什么叫反射
 */
public class TheReflection01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("TheReflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("TheReflection.User");
        Class c3 = Class.forName("TheReflection.User");
        Class c4 = Class.forName("TheReflection.User");
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }

    //测试创建Class类的方法有哪些
    @Test
    public void test1() throws ClassNotFoundException {
        Student student = new Student();
        System.out.println("此人是："+student.name);

        //方法一，使用实例的getClass()方法
        Class c1 = student.getClass();

        //方法二，通过类的class属性
        Class<Student> c2 = Student.class;

        //方法三，已知类全名和类路径，Class类的静态方法forName()
        Class<?> c3 = Class.forName("TheReflection.User");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        //方法四，基本内置类型的包装类都有TYPE属性
        Class<Integer> type = Integer.TYPE;

        //获得父类类型
        Class c4 = c1.getSuperclass();
        System.out.println(c4);

    }

    //所有类型的Class
    @Test
    public void test2(){
        Class c1 = Object.class;    //类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;  //数组
        Class c4 = int[][].class;   //二维数组
        Class c5 = Override.class;  //注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;   //基本数据类型
        Class c8 = void.class;      //void
        Class c9 = Class.class;     //Class本身

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        //只要元素类型与维度一样，就是同一个Class
        int[] a = new int[10];
        int[] b = new int[5];
        Class<? extends int[]> aClass = a.getClass();
        Class<? extends int[]> bClass = b.getClass();
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
    }


}


