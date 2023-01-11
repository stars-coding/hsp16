package org.example.tankgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 画板
 *
 * @author stars
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {

    // 己方坦克
    private Hero hero;
    // 地方坦克容器
    Vector<EnemyTank> enemyTanks = new Vector<>();
    // 地方坦克数量
    int enemyTankSize = 3;

    public MyPanel() {
        // 初始化己方坦克
        this.hero = new Hero(100, 100);
        // 初始化地方坦克
        for (int i = 0; i < this.enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2);
            this.enemyTanks.add(enemyTank);
        }
    }

    /**
     * 涂料
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 画板填充矩形，默认黑色
        g.fillRect(0, 0, 1000, 750);

        // 绘制己方坦克-封装方法
        this.drawTank(this.hero.getX(), this.hero.getY(), g, this.hero.getDirect(), 0);

        // 绘制己方坦克发射的子弹
        if (this.hero.getShot() != null && this.hero.getShot().isLive()) {
            g.fill3DRect(this.hero.getShot().getX(), this.hero.getShot().getY(), 1, 1, false);
        }

        // 绘制敌方坦克
        for (int i = 0; i < this.enemyTanks.size(); i++) {
            // 从容器中取出敌方坦克
            EnemyTank enemyTank = this.enemyTanks.get(i);
            this.drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);


        }
    }

    /**
     * 绘制坦克
     *
     * @param x      坦克横坐标
     * @param y      坦克纵坐标
     * @param g      画笔工具
     * @param direct 坦克的方向（0：上，1：右，2：下，3：左）
     * @param type   坦克的类型（0：己方，1：敌方）
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        // 根据不同类型的坦克，设置不同的颜色
        switch (type) {
            // 己方坦克颜色
            case 0:
                g.setColor(Color.green);
                break;
            // 敌方坦克颜色
            case 1:
                g.setColor(Color.cyan);
                break;
        }

        // 根据坦克方向，绘制对应形状的坦克
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
            // 1 表示向右
            case 1:
                // 绘制坦克左边车轮
                g.fill3DRect(x, y, 60, 10, false);
                // 绘制坦克右边车轮
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 绘制坦克中间车身
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 绘制坦克中间顶盖
                g.fillOval(x + 20, y + 10, 20, 20);
                // 绘制坦克中间炮筒
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            // 2 表示向下
            case 2:
                // 绘制坦克左边车轮
                g.fill3DRect(x, y, 10, 60, false);
                // 绘制坦克右边车轮
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 绘制坦克中间车身
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 绘制坦克中间顶盖
                g.fillOval(x + 10, y + 20, 20, 20);
                // 绘制坦克中间炮筒
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            // 3 表示向左
            case 3:
                // 绘制坦克左边车轮
                g.fill3DRect(x, y, 60, 10, false);
                // 绘制坦克右边车轮
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 绘制坦克中间车身
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 绘制坦克中间顶盖
                g.fillOval(x + 20, y + 10, 20, 20);
                // 绘制坦克中间炮筒
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 处理 WDSA 键按下的情况
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // 向上
        if (e.getKeyCode() == KeyEvent.VK_W) {
            // 改变坦克的方向
            this.hero.setDirect(0);
            // 改变坦克的坐标
            this.hero.moveUp();
            // 向右
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.hero.setDirect(1);
            this.hero.moveRight();
            // 向下
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.hero.setDirect(2);
            this.hero.moveDown();
            // 向左
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.hero.setDirect(3);
            this.hero.moveLeft();
        }

        // 按下 J 键，发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            this.hero.shotEnemyTank();
        }

        // 重新绘制
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        // 每隔 100 毫秒，重新绘制
        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 重新绘制
            this.repaint();
        }
    }
}
