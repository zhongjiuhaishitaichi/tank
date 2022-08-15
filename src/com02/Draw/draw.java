package com02.Draw;

import javax.swing.*;
import java.awt.*;

public class draw extends JFrame {  //画框
    private MyPanel mp = null;//有编译类型 但是并没有创建真的对象

    public static void main(String[] args) {
        new draw();

    }

    public draw() {//构造器 初始化
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当点击叉号的时候程序退出
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {//面板

    @Override
    public void paint(Graphics g) {//绘图方法  画笔
        super.paint(g);//调用父类的方法 完成初始化
      /*  g.setColor(Color.blue);
        g.drawOval(10,10,50,100);//draw 画
        g.fillRect(100,100,50,50);//fill 填充*/
        // 放入图片
        // 获取 绘制
    /*    Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/learn.png"));
        g.drawImage(image, 10, 10, 1920, 1080, this);*/
        g.setColor(Color.CYAN);// 字体颜色
        g.setFont(new Font("隶书",Font.BOLD,50));//字体 是不是粗体 大小
        g.drawString("软件工程",100,100);//x y 对应的是左下角

    }
}