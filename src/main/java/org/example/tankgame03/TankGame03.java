package org.example.tankgame03;

import javax.swing.*;

/**
 * @author stars
 * @version 1.0
 */
public class TankGame03 extends JFrame {

    // 画板
    private MyPanel myPanel;

    public TankGame03() {
        // 初始化画板
        this.myPanel = new MyPanel();
        Thread thread = new Thread(this.myPanel);
        thread.start();
        this.add(this.myPanel);
        this.setSize(1000, 750);
        this.addKeyListener(this.myPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        // 创建画框
        new TankGame03();
    }
}
