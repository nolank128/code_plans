package Java8.TheReference;

import Java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;


public class ConstructorRefTest {
    /**
     * 构造器引用
     * Supplier 中的T get()
     */
    @Test
    public void test1(){
        Supplier<Employee>sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        Supplier<Employee> sup1 = () -> new Employee();
        sup1.get();

        //类名::new  即引用了构造器 ::应该就是引用的意思
        Supplier<Employee> sup2 = Employee::new;
        sup2.get();
    }

    /**
     * 数组引用
     */
    @Test
    public void test2(){
        Function<Integer,String[]> func1 = len -> new String[len];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        //String[]看作一个类型就完了
        Function<Integer,String[]> func2 = String[]::new;
        String [] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
