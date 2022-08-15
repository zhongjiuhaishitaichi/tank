package com03.TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.Vector;

public class swxTankGame02 extends JFrame {
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new swxTankGame02();
    }

    public swxTankGame02() throws HeadlessException {
        System.out.println("是否继续上局游戏?");
        String key=scanner.next();
        mp = new MyPanel(key);
        new Thread(mp).start();//线程启动
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1350, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //监听器 当窗口关闭的时候调用记录方法. 系统退出
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keyRecord();
                System.exit(0);
            }
        });
    }
}
