package TheReflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射，动态创建类的对象
 */
public class TheReflection06 {
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class<?> c1 = Class.forName("TheReflection.User");

        //构造一个真实对象(无参)
        User user = (User)c1.newInstance();//本质上调用了类的无参构造，类要声明无参构造，否则将报错
        System.out.println(user);

        System.out.println();

        //通过构造器，构造一个真实对象(有参)
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User grant = (User) declaredConstructor.newInstance("Grant", 20, 12000);
        System.out.println(grant);

        System.out.println();
        //通过反射调用方法
        //首先通过getDeclaredMethod方法得到Method对象，参数（要调用的方法名，目标方法形参的class属性）
        Method getName = c1.getDeclaredMethod("getName", null);
        System.out.println(getName.invoke(grant));
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //通过invoke(激活)方法调用目标方法
        setName.invoke(grant,"grant");
        System.out.println(getName.invoke(grant));

        System.out.println();
        //通过反射操作属性
        User user1 = (User) c1.newInstance();
        //首先通过getDeclaredField方法得到Field对象，参数（要操作的属性名）
        Field declaredField = c1.getDeclaredField("name");
        System.out.println(user1.getName());
        //通过set方法来设置值，当然也有其它操作(如get，equals)
        declaredField.set(user1,"Haliburton");
        System.out.println(user1.getName());


    }
}
