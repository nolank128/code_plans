package shoot.Day01;
import java.awt.image.BufferedImage;

public abstract class FlyingObject{
     protected BufferedImage image;
     protected int width;
     protected int height;
     protected int x;
     protected int y;


     //共同的属性，行为
     protected abstract  void step();

     public abstract boolean outOfBounds();

     //判断子弹是否打中敌人，在一定区域范围就算打中。
     public boolean shootBy(Bullet bullet){
          int x1=this.x;
          int x2=this.x+this.width;
          int y1=this.y;
          int y2=this.y+this.height;
          int x= bullet.x;
          int y=bullet.y;

          return x>x1 &&x<x2 &&y>y1 &&y<y2;
     }




}
