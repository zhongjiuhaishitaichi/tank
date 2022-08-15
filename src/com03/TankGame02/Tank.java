package com03.TankGame02;

public class Tank {
    private int x;
    private int y;
    private int direction;//初始化为0
    private int speed;//封装
    public boolean isLive=true;

    public void moveUp() {
        y -= this.getSpeed();
    }

    public void moveDown() {
        y += this.getSpeed();
    }

    public void moveRight() {
        x += this.getSpeed();
    }

    public void moveLeft() {
        x -= this.getSpeed();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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
}
