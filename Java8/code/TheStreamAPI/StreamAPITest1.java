package Java8.TheStreamAPI;

import Java8.Employee;
import Java8.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 */
public class StreamAPITest1 {
    //筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

        //filter(Predicate p)--接收lambda，从中排除某些元素
        //查询员工表中薪资大于15000的员工姓名和实际薪水
        stream.filter(e -> e.getSalary()>=15000).forEach(e -> System.out.println(e.getName()+" "+e.getSalary()));

        //limit(n)--截断流，使其元素不超过n
        list.stream().limit(2).forEach(System.out::println);

        //skip(n)--跳过元素，返回一个扔掉了前n个元素的stream若stream中的元素不足n个，则返回一个
        list.stream().skip(2).forEach(System.out::println);

        System.out.println();
        //distinct()--筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1009,"Crack",22,13000));
        list.add(new Employee(1009,"Crack",22,13000));
        list.add(new Employee(1009,"Crack",22,13000));
        list.add(new Employee(1009,"Crack",22,13000));

        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        //map(Function f)--接收一个函数作为参数，将元素转换成其它形式或提取信息，该函数会被应用到每一个元素上去，并将其映射成一个新的元素
        List<String> list = Arrays.asList("boston", "celtics");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println();
        //练习：获取长度大于三的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(n->n.length()>3).forEach(System.out::println);

        System.out.println();
        //练习：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s->{
            s.map(Character::toUpperCase).forEach(System.out::println);
        });
        System.out.println();
        //flatMap(Function f)--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.map(Character::toUpperCase).forEach(System.out::println);
    }

    //排序
    @Test
    public void test3(){
        //sorted() 自然排序
        List<Integer> list = Arrays.asList(12, 44, 89, 21, 34, 0, -2, 11);
        list.stream().sorted().forEach(System.out::println);

        /*
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted().forEach(System.out::println);
        抛异常，Employee类没有实现Comparable接口
        */
        //sorted(Comparator com) 定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> {
            int ageValue = Integer.compare(e1.getAge(),e2.getAge());
            if(ageValue != 0){
                return ageValue;
            }else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换成对应单Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
}
