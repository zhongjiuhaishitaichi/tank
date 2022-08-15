package com03.TankGame03;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

   public static Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //当 MyPanel 里调用这个方法的时候 就可以把那里面的敌人坦克传到EnemyTank这个类里了
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public static Vector<Shot> getShots() {
        return shots;
    }

    public boolean IsTouchEnemyTank() {
        for (int i = 0; i < enemyTanks.size() - 1; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = i + 1; j < enemyTanks.size(); j++) {
                EnemyTank OtherEnemyTank = enemyTanks.get(j);
                switch (enemyTank.getDirection()) {
                    //分别用两个点判断是否碰撞
                    case 0://上
                        if (OtherEnemyTank.getDirection() == 0 || OtherEnemyTank.getDirection() == 2) {
                            if (enemyTank.getX() >= OtherEnemyTank.getX() &&
                                    enemyTank.getX() <= OtherEnemyTank.getX() + 40 &&
                                    enemyTank.getY() >= OtherEnemyTank.getY() &&
                                    enemyTank.getY() <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                            if (enemyTank.getX() + 40 >= OtherEnemyTank.getX() &&
                                    enemyTank.getX() + 40 <= OtherEnemyTank.getX() + 40 &&
                                    enemyTank.getY() >= OtherEnemyTank.getY() &&
                                    enemyTank.getY() <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                        } else {
                            //2. 当前坦克 左上角的坐标 [enemyTank.getX(), enemyTank.getY()]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() >= OtherEnemyTank.getY()
                                    && enemyTank.getY() <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                            //3. 当前坦克 右上角的坐标 [enemyTank.getX() + 40, enemyTank.getY()]
                            if (enemyTank.getX() + 40 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 40 <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() >= OtherEnemyTank.getY()
                                    && enemyTank.getY() <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                    case 2:
                        if (OtherEnemyTank.getDirection() == 0 || OtherEnemyTank.getDirection() == 2) {
                            //2. 当前坦克 左下角的坐标 [OtherOtherEnemyTank.getX(), OtherEnemyTank.getY() + 60]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 40
                                    && enemyTank.getY() + 60 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 60 <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                            //3. 当前坦克 右下角的坐标 [enemyTank.getX() + 40, enemyTank.getY() + 60]
                            if (enemyTank.getX() + 40 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 40 <= OtherEnemyTank.getX() + 40
                                    && enemyTank.getY() + 60 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 60 <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是 右/左
                        //1. 如果敌人坦克是右/左  x的范围 [enemyTank.getX(), enemyTank.getX() + 60]
                        //                     y的范围 [enemyTank.getY(), enemyTank.getY() + 40]
                        if (OtherEnemyTank.getDirection() == 1 || OtherEnemyTank.getDirection() == 3) {
                            //2. 当前坦克 左下角的坐标 [enemyTank.getX(), enemyTank.getY() + 60]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() + 60 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 60 <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                            //3. 当前坦克 右下角的坐标 [enemyTank.getX() + 40, enemyTank.getY() + 60]
                            if (enemyTank.getX() + 40 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 40 <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() + 60 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 60 <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                    case 1:
                        if (OtherEnemyTank.getDirection() == 0 || OtherEnemyTank.getDirection() == 2) {
                            //2. 当前坦克 右上角的坐标 [enemyTank.getX() + 60, enemyTank.getY()]
                            if (enemyTank.getX() + 60 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 60 <= OtherEnemyTank.getX() + 40
                                    && enemyTank.getY() >= OtherEnemyTank.getY()
                                    && enemyTank.getY() <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                            //3. 当前坦克 右下角的坐标 [enemyTank.getX() + 60, enemyTank.getY() + 40]
                            if (enemyTank.getX() + 60 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 60 <= OtherEnemyTank.getX() + 40
                                    && enemyTank.getY() + 40 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 40 <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是 右/左
                        //1. 如果敌人坦克是右/左  x的范围 [enemyTank.getX(), enemyTank.getX() + 60]
                        //                     y的范围 [enemyTank.getY(), enemyTank.getY() + 40]
                        if (OtherEnemyTank.getDirection() == 1 || OtherEnemyTank.getDirection() == 3) {
                            //2. 当前坦克 右上角的坐标 [enemyTank.getX() + 60, enemyTank.getY()]
                            if (enemyTank.getX() + 60 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 60 <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() >= OtherEnemyTank.getY()
                                    && enemyTank.getY() <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                            //3. 当前坦克 右下角的坐标 [enemyTank.getX() + 60, enemyTank.getY() + 40]
                            if (enemyTank.getX() + 60 >= OtherEnemyTank.getX()
                                    && enemyTank.getX() + 60 <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() + 40 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 40 <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                    case 3:
                        if (OtherEnemyTank.getDirection() == 0 || OtherEnemyTank.getDirection() == 2) {
                            //2. 当前坦克 左上角的坐标 [enemyTank.getX(), enemyTank.getY() ]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 40
                                    && enemyTank.getY() >= OtherEnemyTank.getY()
                                    && enemyTank.getY() <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                            //3. 当前坦克 左下角的坐标 [enemyTank.getX(), enemyTank.getY() + 40]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 40
                                    && enemyTank.getY() + 40 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 40 <= OtherEnemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是 右/左
                        //1. 如果敌人坦克是右/左  x的范围 [enemyTank.getX(), enemyTank.getX() + 60]
                        //                     y的范围 [enemyTank.getY(), enemyTank.getY() + 40]
                        if (OtherEnemyTank.getDirection() == 1 || OtherEnemyTank.getDirection() == 3) {
                            //2. 当前坦克 左上角的坐标 [enemyTank.getX(), enemyTank.getY() ]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() >= OtherEnemyTank.getY()
                                    && enemyTank.getY() <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                            //3. 当前坦克 左下角的坐标 [enemyTank.getX(), enemyTank.getY() + 40]
                            if (enemyTank.getX() >= OtherEnemyTank.getX()
                                    && enemyTank.getX() <= OtherEnemyTank.getX() + 60
                                    && enemyTank.getY() + 40 >= OtherEnemyTank.getY()
                                    && enemyTank.getY() + 40 <= OtherEnemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;

                }
            }
        }
        return false;
    }

    @Override
    public void run() {//在创建敌人坦克的时候创建线程
        while (true) {
            if (isLive && shots.size() <= 10) {
                Shot s = null;
                //创建对应的子弹
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            setSpeed(3);
            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0 && !IsTouchEnemyTank())
                            moveUp();
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000 && !IsTouchEnemyTank())
                            moveRight();
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750 && !IsTouchEnemyTank())
                            moveDown();
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0 && !IsTouchEnemyTank())
                            moveLeft();
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            setDirection((int) (Math.random() * 4));
            //多线程一定要考虑什么时候退出!!!
            if (!isLive)
                break;
        }
    }
}
