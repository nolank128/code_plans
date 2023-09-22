package com.project.smart_campus.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/12:19
 */
public class CreateVerifiCodeImage {

    /*
    * 定义长宽，字符大小，验证码，验证码图片
    * */
    private static int WIDTH = 90;
    private static int HEIGHT = 35;
    private static int FONT_SIZE = 20;
    private static char[] verifiCode;
    private static BufferedImage verifiCodeImage;

    /**
     * @description: 获取验证码图片
     * @param: no
     * @return: java.awt.image.BufferedImage
     */
    public static BufferedImage getVerifiCodeImage() {
        //生成一张指定大小的图片
        verifiCodeImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);// create a image
        //获取画笔对象
        Graphics graphics = verifiCodeImage.getGraphics();

        //随机生成验证码
        verifiCode = generateCheckCode();
        //背景为画笔对象
        drawBackground(graphics);

        drawRands(graphics, verifiCode);

        //销毁程序中指定的图形界面资源，对数据资源不产生影响.
        graphics.dispose();
        //返回验证码图片
        return verifiCodeImage;
    }

    /**
     * @description: 获取验证码
     * @param: no
     * @return: char[]
     */
    public static char[] getVerifiCode() {
        return verifiCode;
    }

    /**
     * @description: 随机生成验证码
     * @param: no
     * @return: char[]
     */

    private static char[] generateCheckCode() {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++) {
            //0-52
            int rand = (int) (Math.random() * (10 + 26 * 2));
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

    /**
     * @description: 绘制验证码
     * @param: g
     * @param: rands
     * @return: void
     */
    private static void drawRands(Graphics g, char[] rands) {

        //设置字体，加粗，默认大小 20
        g.setFont(new Font("Console", Font.BOLD, FONT_SIZE));

        for (int i = 0; i < rands.length; i++) {
            //设置验证码颜色
            g.setColor(getRandomColor());
            //验证码的布局
            g.drawString("" + rands[i], i * FONT_SIZE + 10, 25);
        }
    }

    /**
     * @description: 绘制验证码图片背景
     * @param: g
     * @return: void
     */
    private static void drawBackground(Graphics g) {

        //定义画笔对象背景颜色和，背景图片大小
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 绘制验证码干扰点
        for (int i = 0; i < 200; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            g.setColor(getRandomColor());
            g.drawOval(x, y, 1, 1);

        }
    }


    /**
     * @description: 获取随机颜色
     * @param: no
     * @return: java.awt.Color
     */
    private static Color getRandomColor() {
        Random ran = new Random();
        //三原色
        return new Color(ran.nextInt(220), ran.nextInt(220), ran.nextInt(220));
    }


}
