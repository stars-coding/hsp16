package org.example.tankgame03;

/**
 * 子弹
 *
 * @author stars
 * @version 1.0
 */
public class Shot implements Runnable {

    // 子弹的横坐标
    private int x;
    // 子弹的纵坐标
    private int y;
    // 子弹的方向（0：上，1：右，2：下，3：左）
    private int direct;
    // 子弹的速度
    private int speed = 8;
    // 子弹是否存活
    private boolean isLive = true;

    @Override
    public void run() {

        while (true) {

            // 子弹休眠 50 毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 根据子弹的方向改变子弹坐标
            switch (this.direct) {
                // 向上
                case 0:
                    this.y -= this.speed;
                    break;
                // 向右
                case 1:
                    this.x += this.speed;
                    break;
                // 向下
                case 2:
                    this.y += this.speed;
                    break;
                // 向左
                case 3:
                    this.x -= this.speed;
                    break;
            }

            // 当子弹移动至画板边界时，就应该被销毁
            if (!(x > 0 && x < 1000 && y > 0 && y < 750)) {
                this.isLive = false;
                break;
            }
        }


    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
