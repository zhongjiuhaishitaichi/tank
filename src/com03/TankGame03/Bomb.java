package com03.TankGame03;

public class Bomb {
    int x;
    int y;
    int life = 8;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown() {
        if (isLive) {
            life--;
        } else {
            isLive = false;
        }
    }
}
