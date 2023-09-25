package Java8.TheStreamAPI;

import Java8.Employee;
import Java8.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream关注的是对数据的计算，与CPU打交道
 *   集合关注的是数据的存储，与内存打交道
 * 1. Stream不自己存储数据
 * 2. Stream不会改变源对象，相反，他们会返回一个持有结果的新Stream
 * 3. Stream的操作是延迟的。这意味着他们会等到需要结果的时候再执行
 * 执行流程：
 * 1. Stream的实例化
 * 2. 一系列的中间操作（过滤、映射...）
 * 3. 终止操作
 */
public class SteamAPITest {
    //通过集合创建Stream
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }
    //通过数组创建Stream
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的静态方法  static <T> Stream<T> stream(T[] array):返回一个数组流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1111,"KK",20,5000);
        Employee e2 = new Employee(1112,"CC",20,5000);
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //通过调用Stream类的静态方法of(),通过显示值创建一个流。它可以接收任意数量的参数
    @Test
    public void test3(){
        //public static<T> Stream<T> of(T values...):返回一个流
        Stream<Double> doubleStream = Stream.of(43.1, 55.2);
    }

    //使用静态方法Stream.iterate()和Stream.generate(),创建无限流
    @Test
    public void test4(){
        //迭代，遍历前10个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

    }



}
