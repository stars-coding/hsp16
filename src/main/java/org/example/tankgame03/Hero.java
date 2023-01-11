package org.example.tankgame03;

/**
 * 我方坦克
 *
 * @author stars
 * @version 1.0
 */
public class Hero extends Tank {

    // 坦克的子弹
    private Shot shot;

    /**
     * 射击敌方坦克
     */
    public void shotEnemyTank() {
        // 根据当前己方坦克的位置发射子弹
        switch (this.getDirect()) {
            // 向上
            case 0:
                this.shot = new Shot(this.getX() + 20, this.getY(), 0);
                break;
            // 向右
            case 1:
                this.shot = new Shot(this.getX() + 60, this.getY() + 20, 1);
                break;
            // 向下
            case 2:
                this.shot = new Shot(this.getX() + 20, this.getY() + 60, 2);
                break;
            // 向左
            case 3:
                this.shot = new Shot(this.getX(), this.getY() + 20, 3);
                break;
        }
        // 启动子弹线程
        new Thread(this.shot).start();

    }

    public Hero(int x, int y) {
        super(x, y);
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
