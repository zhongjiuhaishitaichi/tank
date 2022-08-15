package com03.Tank;

import javax.swing.*;
import java.awt.*;

//绘图
public class MyPanel extends JPanel {
    MyTank myTank = null;

    public MyPanel() {
        this.myTank = new MyTank(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形 默认是黑色
        DrawTank(myTank.getX(), myTank.getY(), g, 0, 1);
        DrawTank(myTank.getX()+60, myTank.getY(), g, 0, 0);
    }

    //画坦克
    // x y左上角 g画笔 direct 方向 type 类型
    public void DrawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            default:
                System.out.println("后续再改");
        }
    }
}
