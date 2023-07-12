package reactor8;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/16:37
 */
public class Observe extends Observable {
    public static void main(String[] args){

        Observe observe=new Observe();

        /*
        * 响应式编程
        * */
        //添加观察者
        observe.addObserver((o,arg)->{
            System.out.println("实施改变");
        });

        observe.addObserver((o,arg)->{
            System.out.println("接受通知，准备改变");
        });

        observe.setChanged();//数据变化
        observe.notifyObservers();//通知


    }
}
