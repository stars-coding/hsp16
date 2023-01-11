package org.example.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 画框
 *
 * @author stars
 * @version 1.0
 */
public class DrawCircle extends JFrame {

    // 定义一个画板
    private MyPanel myPanel;

    public DrawCircle() {
        // 初始化面板
        myPanel = new MyPanel();
        // 将画板放进画框中
        this.add(myPanel);
        // 设置画框（窗口）大小
        this.setSize(400, 300);
        // 点击窗口的“X”，程序退出
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 可视化
        this.setVisible(true);
    }

    public static void main(String[] args) {
        DrawCircle drawCircle = new DrawCircle();
    }
}

/**
 * 画板
 */
class MyPanel extends JPanel {

    /**
     * 涂料方法
     *
     * @param g 相当于画笔
     */
    @Override
    public void paint(Graphics g) {
        // 调用父类方法完成初始化
        super.paint(g);
        g.drawOval(10, 10, 100, 100);
    }
}