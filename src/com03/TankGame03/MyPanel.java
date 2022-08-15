package com03.TankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//绘图
public class MyPanel extends JPanel implements KeyListener, Runnable {//把MyPanel实现线程 刷新重绘 显示子弹
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();//vector 保证线程安全  敌人都放在集合里面
    int enemyTanksSize = 5;
    //存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    Vector<Wall> walls=new Vector<>();
    Vector<Shot> shots=new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel(String key) {// 一开始创建对象  构造器
        nodes = Recorder.getNodes();
        Recorder.setEnemyTankVector(enemyTanks);//传入集合
        this.myTank = new MyTank(100, 100);
        myTank.setSpeed(10);
        switch (key) {
            case "1":// 不恢复游戏
                for (int i = 0; i < enemyTanksSize; i++) {
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                    //在这里调用set方法 把敌人坦克传进去
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirection(0);
                    new Thread(enemyTank).start();
                    //给每个敌人加入一颗子弹 放入vector成员里
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
                    enemyTank.shots.add(shot);
                    //启动线程
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
            case "2"://恢复游戏
                //   体会这里封装node 思路
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    //在这里调用set方法 把敌人坦克传进去
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirection(node.getDirect());
                    new Thread(enemyTank).start();
                    //给每个敌人加入一颗子弹 放入vector成员里
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
                    enemyTank.shots.add(shot);
                    //启动线程
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }

            default:
                System.out.println("您的输入有误..");
        }

        //在构造器里初始化爆炸图像
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));
    }

    //绘制记录板
    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体", Font.BOLD, 25));
        g.drawString("您累计摧毁敌方坦克数: ", 1020, 30);
        DrawTank(1020, 60, g, 0, 1);//画一个敌方坦克
        g.setColor(Color.BLACK);
        g.drawString("×" + Recorder.getAllEnemyTankNum() + "", 1080, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形 默认是黑色
        showInfo(g);
        //自己的坦克
        if (myTank.isLive) {//我的坦克存活时 绘制坦克和子弹线程
            DrawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), 0);
            //遍历集合 -->绘制子弹
            for (int i = 0; i < myTank.shots.size(); i++) {
                //绘制子弹线程
                Shot shot = myTank.shots.get(i);
                if (shot != null && shot.isLive == true) {//当这个单个子弹不为空 且存活的时候
                    g.draw3DRect(shot.getX() - 1, shot.getY() - 1, 2, 2, false);//子弹
                } else {
                    myTank.shots.remove(shot);
                }
            }
        }
        //遍历vector 获得敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);//集合  取出敌人坦克

            if (enemyTank.isLive) {//敌人坦克存活时才画出坦克
                DrawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
                //获得敌人坦克子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出敌人坦克子弹
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.draw3DRect(shot.getX() - 1, shot.getY() - 1, 2, 2, false);//敌人子弹
                    } else {
                        enemyTank.shots.remove(shot);//移除
                    }
                }
            }
        }
        //显示炸弹爆炸情况
        for (int i = 0; i < bombs.size(); i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();//生命先判断 再减减  用于显示由三张图片构成的gif图
            if (bomb.life == 0) {//生命值为0的时候移除
                bombs.remove(bomb);
            }
        }

        for (int i = 0; i < walls.size(); i++) {
            Wall wall=walls.get(i);
            if (wall.WallisLive) {
                g.setColor(Color.white);
                g.fill3DRect(100 + 10 * i, 100 + 10 * i, 10, 10, false);
            }
            if (!wall.WallisLive){
                walls.remove(wall);
            }
        }
    }

    //画坦克
    // x y左上角 g画笔 direct 方向 type 类型
    public void DrawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.WHITE);
                break;
            case 1:
                g.setColor(Color.CYAN);
                break;
        }
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("后续再改");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            if (myTank.getX() + 60 < 1000) {
                myTank.moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            if (myTank.getY() + 60 < 750) {
                myTank.moveDown();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {//按下按键  就会调用方法
           /* if (myTank.shot==null||!myTank.shot.isLive) {//shot 为空的时候 或者不存活的时候
                myTank.shotEnemy();
            }*/  //单个子弹的情况
            myTank.shotEnemy();
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void hitMyTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (shot.isLive && myTank.isLive) {
                    hitTank(shot, myTank);
                }
            }
        }
    }

    public void hitEnemyTank() {//我的子弹打敌人
        for (int i = 0; i < myTank.shots.size(); i++) {
            Shot shot = myTank.shots.get(i);
            if (shot != null && shot.isLive) {//我的子弹存活
                //遍历敌人坦克
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot, enemyTank);//调用
                }
            }
        }
    }

    public void hitTank(Shot s, Tank Tank) {
        switch (Tank.getDirection()) {
            case 0:
            case 2://上下的判断
                if (s.getX() > Tank.getX() && s.getX() < Tank.getX() + 40 &&
                        s.getY() > Tank.getY() && s.getY() < Tank.getY() + 60) {
                    s.isLive = false;
                    Tank.isLive = false;
                    if (Tank instanceof EnemyTank) {
                        enemyTanks.remove(Tank);
                        Recorder.addAllEnemyTank();
                    } else if (Tank instanceof MyTank && myTank.isLive) {
                        myTank.isLive = false;
                    }
                    //被击中的时候把炸弹放上
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3://左右的判断
                if (s.getX() > Tank.getX() && s.getX() < Tank.getX() + 60 &&
                        s.getY() > Tank.getY() && s.getY() < Tank.getY() + 40) {
                    s.isLive = false;
                    Tank.isLive = false;
                    if (Tank instanceof EnemyTank) {
                        enemyTanks.remove(Tank);
                        Recorder.addAllEnemyTank();
                    } else if (Tank instanceof MyTank && myTank.isLive) {
                        myTank.isLive = false;
                    }
                    //被击中的时候把炸弹放上
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }
    public Vector<Shot> getShots(){
        //注意这里为啥是getShots().size() 动态的子弹数量 可能会销毁
        for (int i = 0; i < EnemyTank.getShots().size(); i++) {
            Shot shot=EnemyTank.shots.get(i);
            shots.add(shot);
        }
        for (int i = EnemyTank.getShots().size(); i < MyTank.getShots().size(); i++) {
            Shot shot=MyTank.shots.get(i);
            shots.add(shot);
        }
        return shots;
    }
    //在run方法里调用   遍历敌人和我的子弹 放在集合里 遍历墙和子弹 当子弹和墙都存活并且子弹到达墙的范围的时候把墙的生命置空
    public void HitWall(){
        for (int i = 0; i < walls.size(); i++) {
            Wall wall=walls.get(i);
            for (int j = 0; j < shots.size(); j++) {
                Shot shot=shots.get(i);
                if (wall.WallisLive){
                    //墙就是长十宽十的正方形
                    if (shot.isLive&&shot.getX()>= wall.getX()&&shot.getX()<=wall.getX()+10&&
                    shot.getY()>=wall.getY()&&shot.getY()<=wall.getY()+10){
                        shot.isLive=false;
                        wall.WallisLive=false;
                    }
                }
            }
        }
    }
    @Override
    public void run() {//因为要判断子弹是否击中敌人(hit方法调用) 一直要遍历所有的坦克(刷新) 所以直接写在run方法里
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitEnemyTank();
            hitMyTank();
            HitWall();
            this.repaint();
        }
    }

}
