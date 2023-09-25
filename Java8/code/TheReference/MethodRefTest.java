package Java8.TheReference;

import Java8.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodRefTest{
    @Test
    public void test1(){
        //Consumer 的 void accept(T t)
        //PrintStream 的 void println(T t)
        
        //使用lambda表达式，并且表达式体自定义
        Consumer<String> con1;
        con1 = str -> System.out.println(str);
        con1.accept("Boston");
        
        //使用方法引用(对象::实例方法)
        PrintStream ps = System.out;
        Consumer<String> con2 = ps :: println;
        con2.accept("Boy");
        
    }
    @Test
    /**
     * Supplier 中的T get()
     * Employee 中的getName()
     * 他们能够做到同一件事
     */
    public void test2(){
       Employee emp1 = new Employee(1,"Bob",22,20);
        Supplier<String>  sup1 = () ->emp1.getName();
        System.out.println(sup1.get());
        System.out.println("***********");
        Employee emp2 = new Employee(2,"Judy",22,20);
        Supplier<String> sup2 = emp2::getName;
        System.out.println(sup2.get());

    }

    @Test
    /**
     * Comparator中的 int compare(T t1,T t2)
     * String中的int t1.compareTo(t2)
     */
    public void test3(){
        Comparator<String> com1 = (s1,s2)-> s1.compareTo(s2);
        System.out.println(com1.compare("fdsa","dafdas"));
        System.out.println("******************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("jojio","jojio"));
    }
}