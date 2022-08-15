package com02.Ticket;

import org.junit.jupiter.api.Test;

@SuppressWarnings({"all"})
public class ThreadTicket01 {
    public static void main(String[] args) {
     /*   SellTicket sellTicket1 = new SellTicket();
        SellTicket sellTicket2 = new SellTicket();
        SellTicket sellTicket3 = new SellTicket();
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();*/

        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();


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
