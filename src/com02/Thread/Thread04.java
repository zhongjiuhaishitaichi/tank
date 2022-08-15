package com02.Thread;

public class Thread04 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.start();
        thread1.start();
    }
}
class T1 implements Runnable{
    @Override
    public void run() {
        int count=0;
        while(true){
            System.out.println("hello world "+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count==10){
                break;
            }
        }
    }
}
class T2 implements Runnable{
    @Override
    public void run() {
        int count2=0;
        while(true){
            System.out.println("软件工程 "+(++count2));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count2==8){
                break;
            }
        }
    }
}

