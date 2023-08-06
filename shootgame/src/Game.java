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

