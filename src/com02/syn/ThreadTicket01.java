package com02.syn;

@SuppressWarnings({"all"})
public class ThreadTicket01 {
    public static void main(String[] args) {
     /*   SellTicket sellTicket1 = new SellTicket();
        SellTicket sellTicket2 = new SellTicket();
        SellTicket sellTicket3 = new SellTicket();
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();*/

   /*     SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();*/

        SellTicket03 sellTicket03 = new SellTicket03();//一个对象 三个线程
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();


    }
}

class SellTicket03 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object();

    public /*synchronized*/ void sell() {//同一时间只有一个线程能调用这个方法 synchronized
        synchronized (object /*this*/) {//可以是this 也可以是一个对象
            if (ticketNum <= 0) {
                System.out.println("车票已卖完...");
                loop = false;
                return;
            } else {
                System.out.println("窗口  " + Thread.currentThread().getName() + " 售出一张票 " +
                        "剩余票数为 " + (--ticketNum));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}


class SellTicket extends Thread {
    private static int ticketNum = 100;

    @Override
    public void run() {

        while (true) {
            if (ticketNum <= 0) {
                System.out.println("车票已卖完...");
                break;
            } else {
                System.out.println("窗口  " + Thread.currentThread().getName() + " 售出一张票 " +
                        "剩余票数为 " + (--ticketNum));
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SellTicket02 implements Runnable {
    private int ticketNum = 100;

    @Override
    public void run() {

        while (true) {
            if (ticketNum <= 0) {
                System.out.println("车票已卖完...");
                break;
            } else {
                System.out.println("窗口  " + Thread.currentThread().getName() + " 售出一张票 " +
                        "剩余票数为 " + (--ticketNum));
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
