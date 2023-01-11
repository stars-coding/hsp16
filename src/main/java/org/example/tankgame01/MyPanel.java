package org.example.tankgame01;

import javax.swing.*;
import java.awt.*;

/**
 * 画板
 *
 * @author stars
 * @version 1.0
 */
public class MyPanel extends JPanel {

    // 己方坦克
    private Hero hero;

    public MyPanel() {
        // 初始化己方坦克
        this.hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形，默认黑色
        g.fillRect(0, 0, 1000, 750);

        // 绘制坦克-封装方法
        this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }

    /**
     * 绘制坦克
     *
     * @param x      坦克横坐标
     * @param y      坦克纵坐标
     * @param g      画笔工具
     * @param direct 坦克的方向
     * @param type   坦克的类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        // 根据不同类型的坦克，设置不同的颜色
        switch (type) {
            // 己方坦克颜色
            case 0:
                g.setColor(Color.cyan);
                break;
            // 敌方坦克颜色
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克方向，绘制坦克
        switch (direct) {
            // 0 表示向上
            case 0:
                // 绘制坦克左边车轮
                g.fill3DRect(x, y, 10, 60, false);
                // 绘制坦克右边车轮
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 绘制坦克中间车身
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 绘制坦克中间顶盖
                g.fillOval(x + 10, y + 20, 20, 20);
                // 绘制坦克中间炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }
}
