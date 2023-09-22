package aop;



import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Callable;



public class jdkproxy {
    public  static  void main(String[] args){

        //创建接口实现类的代理对象
        Class[] interfaces={UserDao.class};



           /* proxy实现
    调用newProxyInstance 方法
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {}
    返回 指定接口的代理类的实例，

    三个参数： 1.类的加载器
             2.增强方法所在的类，这个类实现的接口，支持多个接口，。
             3.实现这个接口InvocationHandler，创建代理对象，写增强的部分

*/


        UserDaoImpl userDao=new UserDaoImpl();
        UserDao userDao1=(UserDao) Proxy.newProxyInstance(jdkproxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
        int result=userDao1.add(1,2);
        System.out.println(result);

       /*
       也可以使用内部类来实现
       Proxy.newProxyInstance(jdkproxy.class.getClassLoader(), interfaces, new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               return null;
           }
       })*/

    }
}


//创建代理对象代码

class UserDaoProxy implements InvocationHandler{
    //创建的是谁的代理对象，将他传递进来
    //有参构造传递进来
    private Object object;
    public UserDaoProxy(Object object){
        this.object=object;
    }

    //增强的逻辑，利用aop实现新增的功能
    /*invoke
    三个参数：1、代理对象
            2、当前的方法
            3、传入的参数

    * */


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前
        System.out.println("方法之前执行...."+method.getName()+" :传递的参数..."+ Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(object, args);


        //方法之后
        System.out.println("方法之后执行...."+object);

        return res;

    }

}

