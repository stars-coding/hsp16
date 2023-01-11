package org.example.test;

/**
 * @author stars
 * @version 1.0
 */
public class Thrad01 {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.start();

        while (true) {
            System.out.println("------------" + "主线程名称：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Cat extends Thread {

    int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("子线程 - 小猫喵喵叫~~~" + this.i++);
            System.out.println("子线程名称：" + Thread.currentThread().getName());
            // 睡眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 60) {
                System.out.println("小猫不叫了！！！");
                break;
            }
        }
    }
}