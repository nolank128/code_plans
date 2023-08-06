package shoot.Day01;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Flying extends FlyingObject {
    //本机属性，生命值，火力，状态
    private int life;
    private int doubleFire;
    private BufferedImage[] images;
    private int index;
    //构造方法
    public Flying() {
        image = Game.benji;
        width = image.getWidth();
        height = image.getHeight();
        x = 150;
        y = 400;
        life = 3;
        doubleFire = 0;
        images = new BufferedImage[]{
                Game.benji, Game.benji1
        };
        index = 0;
    }
    //本机状态的切换
    public void step() {
        //控制两种图片变换时间
        index++;
        int a = index / 50;
        int b = a % 2;
        image = images[b];

    }

    //射击方法
    public Bullet[] shoot() {
        //出炮口位置
        int xStep = this.width / 8;
        int yStep = 30;

        //单倍火力和双倍火力切换条件
        if (doubleFire > 0) {
            Bullet[] bs = new Bullet[2];
            bs[0] = new Bullet(this.x + xStep, this.y - yStep);
            bs[1] = new Bullet(this.x + 3 * xStep, this.y - yStep);
            doubleFire -= 2;
            return bs;

        } else {
            Bullet[] bs = new Bullet[1];
            bs[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
            return bs;
        }
    }
    public void moveTo(int x, int y) {
        this.x = x - this.width/2;
        this.y = y - this.height/2;
    }
    //随鼠标移动，但也要重写该方法
    public boolean outOfBounds(){
        return false;
    }
    //生命值增加和减少
    public  void addLife(){
        life++;
    }
    public int getLife(){
        return life;
    }
    public void clearLife(){
        life--;
    }
    //火力值增加和减少
    public void addDoubleFire(){
        doubleFire+=40;
    }
    public  void clearDoubleFire(){
        doubleFire=0;
    }
    //判断是否撞上敌人，在一定范围就算撞上
    public boolean hit(FlyingObject object ){
        int x1= object.x-this.width/2;
        int x2=object.x+object.width+this.width/2;
        int y1=object.y-this.height/2;
        int y2=object.y+object.height+this.height/2;
        int x=this.x+this.width/2;
        int y=this.y+this.height/2;

        return x>x1&&x<x2&&y>y1&&y<y2;
    }
}
