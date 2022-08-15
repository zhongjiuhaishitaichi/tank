package com03.TankGame03;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyTankNum = 0;
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;
    private static String recordFile = "e:\\myRecord02.txt";
    private static Vector<EnemyTank> enemyTankVector = null;
    private static Vector<Node> nodes = new Vector<>();
    private static String AllEnemyTank;


    //从文件读取信息 用一个个结点 放在vector集合里  在开始游戏的时候调用该方法
    public static Vector<Node> getNodes() {
        try {
            bufferedReader = new BufferedReader(new FileReader(recordFile));
            AllEnemyTank = bufferedReader.readLine();//字符类型装箱成Integer
            String readLine="";
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] s = readLine.split(" ");
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedWriter!=null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }


    //从MyPanel 类里得到所有的敌人坦克   思路: 在其他类里定义集合属性 通过set方法 传入
    public static void setEnemyTankVector(Vector<EnemyTank> enemyTankVector) {
        Recorder.enemyTankVector = enemyTankVector;
    }

    //游戏结束 存储信息
    public static void keyRecord() {
        try {
            //注意  这是替代的哦
            bufferedWriter = new BufferedWriter(new FileWriter(recordFile));
      /*      bufferedWriter.write(allEnemyTankNum + "\r\n");*/
            for (int i = 0; i < enemyTankVector.size(); i++) {
                EnemyTank enemyTank = enemyTankVector.get(i);
                if (enemyTank.isLive) {
                    //字符
                    String recordInfo = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                    bufferedWriter.write(recordInfo + "\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public static void addAllEnemyTank() {
        allEnemyTankNum++;
    }
}
