package org.example.tankgame01;

import javax.swing.*;

/**
 * @author stars
 * @version 1.0
 */
public class TankGame01 extends JFrame {

    // 画板
    private MyPanel myPanel;

    public TankGame01() {
        // 初始化画板
        this.myPanel = new MyPanel();
        this.add(this.myPanel);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        // 创建画框
        new TankGame01();
    }
}
