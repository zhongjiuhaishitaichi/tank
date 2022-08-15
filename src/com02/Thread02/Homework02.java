package com02.Thread02;

public class Homework02 {
    public static void main(String[] args) {
        User user = new User();
        Thread thread1 = new Thread(user);
        Thread thread2 = new Thread(user);
        thread1.start();
        thread2.start();
    }
}

class User implements Runnable {
    private static int AllNum = 10000;
    private boolean loop = true;

    @Override
    public void run() {
        //线程同步
        synchronized (this) {
            while (loop) {
                if (AllNum <= 0) {
                    System.out.println("卡里没钱了..");
                    break;
                }
                AllNum -= 1000;
                System.out.println(Thread.currentThread().getName()+"取钱了 "+"余额为 " + AllNum);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
