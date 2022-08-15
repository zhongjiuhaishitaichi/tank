package com02.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//键控移动
public class ballMove extends JFrame {
    private MyPanel myPanel = null;

    public static void main(String[] args) {
        ballMove ballMove = new ballMove();

    }

    public ballMove() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(400, 300);
        this.addKeyListener(myPanel);// 因为 MyPanel 这个类实现了keylistener这个接口 所以可以把监听器加进去 就是这个对象
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {//KeyListener 可以监听时间

    int x = 10;
    int y = 10;

    //快捷键 alt+enter

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下
    @Override
    //移动
    public void keyPressed(KeyEvent e) {
//        System.out.println((char) e.getKeyCode()+"被按下...");
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 10;
        }
        // 重绘 刷新
        this.repaint();
    }

    //释放
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.fillOval(x, y, 20, 20);//默认黑色
    }
}