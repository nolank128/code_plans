package Java8;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供用于测试的数据
 */
public class EmployeeData {

    /**
     * 这个方法调用后就会返回一个列表
     * @return Employee List
     */
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"Bob",20,12000));
        list.add(new Employee(1002,"Dominic",20,15648));
        list.add(new Employee(1003,"Cindy",20,15618));
        list.add(new Employee(1004,"George",20,15546));
        return list;
    }
}
