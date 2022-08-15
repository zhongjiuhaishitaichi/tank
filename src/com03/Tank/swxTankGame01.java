package com03.Tank;

import javax.swing.*;
import java.awt.*;

public class swxTankGame01  extends JFrame {
    MyPanel mp=null;
    public static void main(String[] args) {
            new swxTankGame01();
    }

    public swxTankGame01() throws HeadlessException {
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
