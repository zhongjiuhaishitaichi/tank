package com03.TankGame03;

import java.util.Vector;

public class MyTank extends Tank {
    public Shot shot;
    public static Vector<Shot> shots = new Vector<>();

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    public static Vector<Shot> getShots() {
        return shots;
    }

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shotEnemy() {//x y都是在最左上角
        if (shots.size() == 5) {//发射为5个的时候 直接返回 不再创建线程
            return;
        }
        switch (getDirection()) {//坦克的方向
            case 0://上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        shots.add(shot);//把新的shot加入 集合
        new Thread(shot).start();//启动每一个shot线程
    }
}
