package shoot.Day01;
import java.util.Random;
public class Airplane extends FlyingObject implements Enemy{
    private int speed=3;

    //敌机的属性，长宽，下落距离，随机产生
    public Airplane(){
        image=Game.enemy;
        width=image.getWidth();
        height=image.getHeight();
        Random rand=new Random();
        x= rand.nextInt(Game.WIDTH-this.width);
        y=-this.height;

    }

    //得分
    public int getScore(){
        return 5;
    }


    //下落距离
    public void step(){
        y+=speed;
    }

    //判断是否出界
    public boolean outOfBounds(){
        return this.y>=Game.HEIGHT;
    }

}
