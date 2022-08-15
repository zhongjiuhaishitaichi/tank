package com02.Thread02;


public class ThreadExercise  {
    public static void main(String[] args) throws InterruptedException {
        sonThread sonThread = new sonThread();
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi..."+i);
            if(i==5){
                Thread thread = new Thread(sonThread);
                thread.start();
                thread.join();
                System.out.println("子线程结束");
            }
        }
        System.out.println("主线程结束");
    }
}
class sonThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=10 ; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("hello "+ i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
