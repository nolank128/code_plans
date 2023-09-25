package TheReflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获得类的各种信息（名字、属性、方法、构造器。。。）
 */
public class TheReflection05 {
   @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
       Class<?> c1 = Class.forName("TheReflection.User");

       //获得类的名字
       System.out.println(c1.getName());

       //获得类的简单名字
       System.out.println(c1.getSimpleName());

       User user = new User();
       Class<? extends User> c2 = user.getClass();
       System.out.println(c2.getName());

       System.out.println();
       //获得类的属性
       Field[] fields = c1.getFields();//getFields()只能找到public属性

       fields = c1.getDeclaredFields();//可找到所有属性
       for (Field field : fields) {
           System.out.println(field);
       }
       System.out.println();

       //获得指定属性的值
       Field name = c1.getDeclaredField("name");
       System.out.println(name);

       System.out.println();

       //获得类的方法
      Method[] methods1 = c1.getMethods();//获得本类及其父类的所有public方法
      Method[] methods = c1.getMethods();//获得所有方法
       for (Method method : methods) {
           System.out.println(method);
       }

      System.out.println();

       //获得指定方法
      //第二个参数的存在是因为函数有重载
      Method getName = c1.getMethod("getName");
      Method setName = c1.getMethod("setName", String.class);
      System.out.println(getName);
      System.out.println(setName);

      System.out.println();

      //获得构造器
      Constructor<?>[] constructors = c1.getConstructors();
      Constructor<?>[] declaredConstructors = c1.getDeclaredConstructors();
      for (Constructor<?> constructor : constructors) {
         System.out.println(constructor);
      }
      for (Constructor<?> declaredConstructor : declaredConstructors) {
         System.out.println(declaredConstructor);
      }

       System.out.println();

      //获得指定构造器
       Constructor<?> declaredConstructor = c1.getDeclaredConstructor();
       System.out.println(declaredConstructor);
   }
}
