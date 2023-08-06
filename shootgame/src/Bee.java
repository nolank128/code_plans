package shoot.Day01;
import java.util.Random;


public class Bee extends FlyingObject implements Award{
    //设定小蜜蜂移动的格数，奖励
    private int xSpeed=1;
    private int ySpeed=2;
    private int awardType;

    //构造方法，自动调用
    public Bee(){
        image=Game.bee;
        //自动获取图片长宽
        width=image.getWidth();
        height=image.getHeight();
        Random rand=new Random();
        x= rand.nextInt(Game.WIDTH-this.width);
       y=-this.height;

       //奖励随机获取
        awardType= rand.nextInt(2);

    }

    //获取奖励类型
    public int getType(){
        return awardType;
    }

    //重写step方法
    public void step(){
        x+=xSpeed;
        y+=ySpeed;
        //判断小蜜蜂是否到达边界，并决定是否返回
        if (x>=Game.WIDTH-this.width){
            xSpeed=-1;
        }
        if (x<=0){
            xSpeed=1;
        }
    }

    //判断是否出界
    public boolean outOfBounds(){
        return this.y>=Game.HEIGHT;
    }
}
