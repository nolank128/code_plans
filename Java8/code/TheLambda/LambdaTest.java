package Java8.TheLambda;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {
    @Test
    public void test1(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Boston");
            }
        };
        r1.run();
        System.out.println("************");
        Runnable r2 = ()-> System.out.println("Boy");
        r2.run();
    }

    @Test
    public void test2(){
        /**
         * 原始写法
         */
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int res1 = com1.compare(21,12);
        System.out.println(res1);

        /**
         * lambda表达式的写法
         */
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int res2 = com2.compare(21,12);
        System.out.println(res2);

        /**
         * 方法引用
         */
        Comparator<Integer> com3 = Integer :: compare;
        int res3 =com3.compare(21,12);
        System.out.println(res3);

    }

}
