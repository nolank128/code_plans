package Java8.TheStreamAPI;

import Java8.Employee;
import Java8.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)--检查是否匹配所有元素。
        //练习：是否所有员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //anyMatch(Predicate p)--检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() < 10000);
        //noneMatch(Predicate p)--检查是否没有匹配的元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getAge() == 22);
        //findFirst--返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        //findAny--返回当前流的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        //count--返回流中元素的总个数
        long count = employees.stream().count();
        //max(Comparator c)--返回流中最大值
        Stream<Integer> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Integer> maxSalary = salaryStream.max((Integer::compare));

        //min(Comparator c)--返回流中最小值
        Optional<Employee> minSalary = employees.stream().min((e1, e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(minSalary);

        //forEach(Consumer c)--内部迭代
        employees.stream().forEach(System.out::println);

    }

    //2-规约
    @Test
    public void test2(){
        //reduce (T identity,BinaryOperator)--可以将流中的元素反复结合起来，得到一个值，返回一个T
        //计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum); //identity 是初始值，后面用方法引用（Integer的sum方法两个参数返回一个同样类型的对象，与reduce的一致）
        System.out.println(sum);

        //reduce(BinaryOperator)--可以将流中的元素反复结合起来，得到一个值，返回Optional<T>
        //计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Integer> sumSalary = employees.stream().map(Employee::getSalary).reduce((d1,d2)->d1+d2);
        System.out.println(sumSalary);
    }

    //3-收集
    @Test
    public void test3(){
        //collect(Collector c)--将流转化为其他形式。接受一个Collector接口的实现，用于给
        //查找工资大于14000的员工，返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        //List
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 14000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println();

        //Set
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 14000).collect(Collectors.toSet());
        employeeList.forEach(System.out::println);
    }

}
