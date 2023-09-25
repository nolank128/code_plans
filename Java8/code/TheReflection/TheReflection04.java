package TheReflection;

public class TheReflection04 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->跟加载器（C/C++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader aClass = Class.forName("TheReflection.TheReflection04").getClassLoader();
        System.out.println(aClass);
        //输出为ClassLoaders$AppClassLoader，即系统类的加载器
    }
}
