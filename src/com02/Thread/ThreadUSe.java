package com02.Thread;

public class ThreadUSe {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        car.start();//start 方法开启线程 开启run() 方法
        System.out.println("主线程进行..." + Thread.currentThread().getName());
        for (int i = 0; i < 8; i++) {
            System.out.println("主线程  " + i);
            Thread.sleep(1000);
        }
    }
}

class Car extends Thread {
    @Override

    public void run() {// 线程  自己写业务逻辑
        int times = 0;
        while (true) {
            System.out.println("汽车启动" + (times) + Thread.currentThread().getName());
            try {// 休眠一秒钟
                Thread.sleep(1000);
                times++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 8)
                break;
        }
    }
}
