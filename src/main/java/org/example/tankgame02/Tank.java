package org.example.tankgame02;

/**
 * @author stars
 * @version 1.0
 */
public class Tank {

    // 坦克的横坐标
    private int x;
    // 坦克的纵坐标
    private int y;
    // 坦克的方向（0：上，1：右，2：下，3：左）
    private int direct;
    // 坦克的速度
    private int speed = 1;

    public void moveUp() {
        this.y -= this.speed;
    }

    public void moveRight() {
        this.x += this.speed;
    }

    public void moveDown() {
        this.y += this.speed;
    }

    public void moveLeft() {
        this.x -= this.speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
