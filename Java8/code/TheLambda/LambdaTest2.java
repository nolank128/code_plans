package Java8.TheLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java内置四大核心函数式接口
 * 消费型接口 Consumer<T> void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T,R> R apply(T t)
 * 断定星接口 Predicate<T> boolean test(T t)
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500,money -> System.out.println("调用了消费性接口"));
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("Bob","Boston","boolean");
        List<String> answer1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("B");
            }
        });
        List<String> answer = filterString(list,The_test -> The_test.contains("b"));
        System.out.println(answer1);
        System.out.println("*********************");
        System.out.println(answer);

    }

    /**
     * 发薪水，用来调用消费性接口
     * @param money
     * @param con
     */
    public void happyTime(double money,Consumer<Double> con){
        con.accept(money);
    }

    /**
     * 根据给定的规则，过滤集合中的字符串。此规则由Predicate接口中的方法决定
     * @param list
     * @param pre
     * @return
     */
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
