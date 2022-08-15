package com03.TankGame03;

public class Shot implements Runnable {
   private int x;
    private int y;
    int direction;
    int speed = 20;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direction = direct;
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

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y+= speed;
                    break;
                case 3://左
                    x-= speed;
                    break;
            }
            System.out.println("子弹 x= "+x+" y= "+y);
            //到边界 或者 碰到坦克退出
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750&&isLive)) {
                isLive = false;
                break;
            }
        }
    }
}
