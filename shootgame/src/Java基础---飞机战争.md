
@[TOC](文章目录)

# 前言
Java基础知识学完后，大家可能都有过自己动手敲一个小游戏的想法吧，我自己之前也动手敲了一个非常常见的飞机射击小游戏，最近整理了一下之前的笔记，把我之前敲得一些代码，思路啥的跟大家分享分享。



# 一、系统分析
## 问题描述
本程序是一个利用Java应用软件制作的飞机大战小游戏。在游戏过程中，用户通过鼠标的移动来控制飞机的运行方向，用鼠标点击控制游戏开始，鼠标移出界面表示暂停；鼠标移入继续进行游戏；程序运行窗口的右上角显示用户在游戏过程中所得的分数和飞机的生命值。当飞机生命值为0时游戏结束。本程序界面美观，随机奖励的设定增加了游戏的趣味性。
## 总体设计
本项目一共用了一个软件包shoot.Day01包，6个类分别为Airplane（小敌机类）Bee(小蜜蜂敌机类)Bullet（子弹类）Flying(本机类)FlyingObject(本机父类，所有敌机父类)Game(总体框架实现类，主类)，2个接口 Award（奖励接口）Enemy(敌机接口）。
## 功能流程图
![在这里插入图片描述](https://img-blog.csdnimg.cn/60f088aa0b7b4b5fa7002ab9c0dd9a58.png#pic_center)



# 二、程序和算法的介绍
## FlyingObject(本机和所有敌机父类)
**定义了所有飞行物的长宽，坐标，以及共同的移动属性，是否出界标准等**

```java
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

```


## Airplane（小敌机类）
**定义小敌机的属性，长宽，下落距离，随机产生小敌机，得分，判断是否出界等。**

```java
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
```
## Bee(小蜜蜂敌机类)
**定义了小蜜蜂移动的格数，奖励，获取奖励类型，判断是否出界等。**

```java
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

```
## Bullet（子弹类）
**定义了子弹基本的下落距离，子弹的移动方法，判断子弹是否出界等。**

```java
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

```
## Flying(本机类)
**定义了本机的基本属性，生命值，火力值，状态，以及射击的方法，随鼠标移动的方法，生命值火力值增加减少的方法，判断是否撞上飞行物的方法。**

```java
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
```
## Enemy(敌机接口)和Award（奖励接口）
 **Enemy(敌机接口)**

```java
package shoot.Day01;
public interface Enemy {
    public int getScore();
}
```
**Award（奖励接口）**

```java
package shoot.Day01;

public interface Award {
    public int Double_File=0;
    public int LIFE=1;
    public int getType();
}

```
这两个接口没有设置太多的功能，大家可以根据自行需要去扩展。

## Game(总体框架实现类，主类)
**继承JPanel类，添加了图片，对各类进行初始化，并加入了计时器等操作。**

```java
package shoot.Day01;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

/**
 * Game(总体框架实现类)主类
 * 继承JPanel类，添加了图片，对各类进行初始化，并加入了计时器等操作。
 * @author ioik
 */
//主程序
public class Game extends JPanel {
    //设定界面长，宽
    public static final int WIDTH=400;
    public static final int HEIGHT=654;

    public static BufferedImage background;
    public static BufferedImage start;
    public static BufferedImage jixu;
    public static BufferedImage benji;
    public static BufferedImage benji1;
    public static BufferedImage end;
    public static BufferedImage bee;
    public static BufferedImage stack;
    public static BufferedImage enemy;


    //设定三种状态
    public static final int START=0;
    public static final int RUNNING=1;
    public static final int PAUSE=2;
    public static final int GAME_OVER=3;
    private int state=START;

    //创建本机对象，敌人数组，子弹数组
    private Flying myfly=new Flying();
    private FlyingObject[] flyings={};
    private Bullet[] bullets={};




   //文件流错误必须要异常处理
    static {
        try{
            //插入图片
            background=ImageIO.read(Game.class.getResource("black.png"));
            start=ImageIO.read(Game.class.getResource("start.png"));
            jixu=ImageIO.read(Game.class.getResource("jixuyouxi.png"));
            end=ImageIO.read(Game.class.getResource("gameover.png"));
            benji=ImageIO.read(Game.class.getResource("benji.png"));
            benji1=ImageIO.read(Game.class.getResource("benji1.png"));
            enemy=ImageIO.read(Game.class.getResource("enemy.png"));
            bee=ImageIO.read(Game.class.getResource("bee.png"));
            stack=ImageIO.read(Game.class.getResource("stack.png"));

        }catch(Exception e){
            //抛出异常
            e.printStackTrace();
        }
    }

    //随机数方法 随机产生敌人和小蜜蜂奖励
    public FlyingObject nextOne(){
        Random rand=new Random();
        int type= rand.nextInt(20);
        if (type<5){
            return new Bee();
        }else{
            return new Airplane();
         }

    }

    //进入函数（自动的）
    int flyEnteredTIndex=0;
    public void enterAction(){
        flyEnteredTIndex++;
        //400ms,调用敌人产生函数每0.4秒产生一次敌人
        if (flyEnteredTIndex%40==0){
            FlyingObject one=nextOne();
            //敌人数组扩容，接收新产生敌人，并赋值于最后一个位置
            flyings=Arrays.copyOf(flyings,flyings.length+1);
            flyings[flyings.length-1]=one;
        }

    }
    //敌人，子弹动起来
    public void stepAction(){
        //调用本机动起来函数
        myfly.step();
        //调用所有子弹，敌人动起来
        for (int i=0;i<flyings.length;i++){
            flyings[i].step();
        }
        for (int i=0;i<bullets.length;i++){
            bullets[i].step();
        }
    }

    //射击方法
    int shootIndex=0;
    public void shootAction(){
        shootIndex++;
        //控制射击频率
        if (shootIndex%30==0){
            //存储子弹
          Bullet[] bs=myfly.shoot();
          bullets=Arrays.copyOf(bullets,bullets.length+bs.length);
          //新产生的子弹放入数组
          System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length);
        }
    }

    //确定是否越界
    public void outOfBoundsAction(){
        int index=0;
        //判断敌人对象是否越界
        FlyingObject[] flyingLives=new FlyingObject[flyings.length];
        for (int i=0;i<flyings.length;i++){
            FlyingObject f=flyings[i];
            //保留未出界对象，出界对象数组缩容除去
            if (!f.outOfBounds()){
                flyingLives[index]=f;
                index++;
            }
        }
        flyings=Arrays.copyOf(flyingLives,index);

        int j=0;
        //判断子弹是否出界
        Bullet[] ba=new Bullet[bullets.length];
        for (int i=0;i<bullets.length;i++){
            Bullet b=bullets[i];
            if (!b.outOfBounds()){
                ba[j]=b;
                j++;
            }
        }
        bullets=Arrays.copyOf(ba,j);
    }

    //子弹撞击
    public void bangAction(){
        for (int i=0;i<bullets.length;i++){
            Bullet b=bullets[i];
            bang(b);
        }
    }

    //子弹撞击方法
    int score=0;
    public void bang(Bullet b){
        int index=-1;
        for (int i=0;i<flyings.length;i++){
            FlyingObject f=flyings[i];
            //成功撞击的子弹
            if (f.shootBy(b)){
                index=i;
                break;
            }
        }

        //成功撞击的子弹确定撞击对象
        if (index!=-1){
            FlyingObject a=flyings[index];
            if (a instanceof Enemy ){
                //向上转型，如果是普通敌人对象就得分
                Enemy e=(Enemy) a;
                score+=e.getScore();
            }
            if (a instanceof Award){
                //如果是小蜜蜂对象，就判断得哪一种奖励，本机加火力值或者加生命值
                Award c=(Award) a;
                int type=c.getType();
                switch (type){
                        case Award.Double_File:
                              myfly.addDoubleFire();
                              break;
                        case Award.LIFE:
                             myfly.addLife();
                              break;
                }
            }

            //成功撞击的敌人需要除去，故进行数组缩容，除去被撞敌人
            FlyingObject t=flyings[index];
            flyings[index]=flyings[flyings.length-1];
            flyings[flyings.length-1]=t;
            flyings=Arrays.copyOf(flyings,flyings.length-1);

        }
    }

    //检查游戏是否结束
   public  void   checkGameOverAction(){
        if (isGameOver()){
           state=GAME_OVER;
        }
   }

   //判断游戏结束的条件
   public boolean isGameOver(){
        for (int i=0;i<flyings.length;i++){
            FlyingObject f=flyings[i];
            if (myfly.hit(f)){
                myfly.clearLife();
                myfly.clearDoubleFire();

                //撞击后的敌机消失，数组缩容
                FlyingObject t=flyings[i];
                flyings[i]=flyings[flyings.length-1];
                flyings[flyings.length-1]=t;
                flyings=Arrays.copyOf(flyings,flyings.length-1);
            }
        }
     return myfly.getLife() <=0;

    }



    //减少main函数的负担
    public void action(){

        //鼠标点击，运行状态下本机随着鼠标移动
        MouseAdapter  l=new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                if (state==RUNNING) {
                    int x = e.getX();
                    int y = e.getY();
                    myfly.moveTo(x, y);
                }
            }



            public void mouseClicked(MouseEvent e){
                switch (state){
                    //鼠标点击，开始游戏
                    case START:
                        state=RUNNING;
                        break;
                        //游戏结束后，敌人子弹消失，得分为0；再次点击，游戏重新开始
                    case GAME_OVER:
                        score=0;
                        myfly=new Flying();
                        flyings=new FlyingObject[0];
                        bullets=new Bullet[0];
                        state=START;
                        break;
                }
            }

            //移出鼠标，游戏暂停
            public void mouseExited(MouseEvent e){
                if (state==RUNNING){
                    state=PAUSE;
                }
            }
            //移入鼠标，游戏暂停
            public void mouseEntered(MouseEvent e){
                if (state==PAUSE){
                    state=RUNNING;
                }
            }
        };
        this.addMouseListener(l);
        this.addMouseMotionListener(l);


        //添加计时器，并设定时间间隔为10毫秒
        Timer timer=new Timer();
        int intervel=10;
        timer.schedule(new TimerTask() {
            public void run() {
                if (state == RUNNING) {
                    enterAction();
                    stepAction();
                    shootAction();
                    outOfBoundsAction();
                    bangAction();
                    checkGameOverAction();
                }
                repaint();
            }
        }, intervel, intervel);
    }


    //画板，画背景，画敌机，画本机，画状态
    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        paintmyfly(g);
        paintBullets(g);
        paintFlyingObjects(g);
        paintSA(g);
        paintState(g);
    }

    //画本机
    public void paintmyfly(Graphics g){
       g.drawImage(myfly.image,myfly.x,myfly.y,null);
    }

    //画敌机，小蜜蜂，随机产生
    public void paintFlyingObjects(Graphics g){
      for (int i=0;i<flyings.length;i++){
          FlyingObject f=flyings[i];
          g.drawImage(f.image,f.x,f.y,null);
      }
    }

    //画子弹
    public void paintBullets(Graphics g){
        for (int i=0;i<bullets.length;i++){
            Bullet b=bullets[i];
            g.drawImage(b.image,b.x,b.y,null);
        }
    }


    public void paintSA(Graphics g){
           g.setColor(new Color(0xFF0000));
           g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
           g.drawString("SCORE:"+score,10,25);
           g.drawString("LIFE:"+myfly.getLife(),10,45);
    }
    public void paintState(Graphics g){
        switch (state){
            case START:
                g.drawImage(start,100,250,null);
                break;
            case PAUSE:
                g.drawImage(jixu,80,250,null);
                break;
            case GAME_OVER:
                g.drawImage(end,100,250,null);
                break;
        }
    }


    public static void main(String[] args){
        JFrame frame=new JFrame("Shooting");
        Game game=new Game();
        frame.add(game);
        frame.setSize(WIDTH,HEIGHT);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.action();

    }

}


```
# 三、界面设计
## 游戏界面设计
界面美观是用户游戏时，眼球的愉悦感和游戏的吸引力之一。
游戏界面：背景，本机，小敌机，小蜜蜂敌机

```java
background=ImageIO.read(Game.class.getResource("black.png"));
```
将图片路径装在Game类中，，在游戏面板上，以此面板作为观察者用Graphics进行重画。
**1.游戏面板进行时界面：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/4da83646fca34ff0b0db9c1e4d771482.png#pic_center)
**2.游戏进行界面**
![在这里插入图片描述](https://img-blog.csdnimg.cn/f223e30a010a409088df5f0c52bf47ed.png#pic_center)
**3.	游戏结束界面**
在重画面板时进行判断若本机生命值为0，即弹出“Game Over”界面。
![在这里插入图片描述](https://img-blog.csdnimg.cn/e207e2f72f744f1b9561a2a8ad85a0b3.png#pic_center)
**4.	分数显示栏，用标签和文本域实现，生命值初始为3。**
![在这里插入图片描述](https://img-blog.csdnimg.cn/88ce07ad458c46cbb5a935e6897448d1.png#pic_center)


