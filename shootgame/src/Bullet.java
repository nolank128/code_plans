package shoot.Day01;

import java.util.Random;

public class Bullet extends FlyingObject{
    private int speed=3;

   //子弹构造方法，传参随本机
    public Bullet(int x,int y){
        image=Game.stack;
        width=image.getWidth();
        height=image.getHeight();
        this.x=x;
        this.y=y;
    }
    //子弹移动方法
    public void step(){
     y-=speed;
    }

    //判断子弹是否出界
    public boolean outOfBounds(){
        return this.y<=-this.height;
    }


}
