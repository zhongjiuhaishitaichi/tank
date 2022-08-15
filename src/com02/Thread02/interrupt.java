package com02.Thread02;

public class interrupt {
    public static void main(String[] args) throws InterruptedException {
        T r = new T();
        r.setName("保时捷");
        r.setPriority(Thread.MAX_PRIORITY);
        r.start();
        System.out.println(r.getPriority());
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("数数进行中 "+ i);
           /* if(i==5){
                r.join();
            }*/
        }
        r.interrupt();
    }
}
class  T extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            while(true){
                System.out.println(Thread.currentThread().getName() +"正在起飞...");
                try {
                    System.out.println(Thread.currentThread().getName()+" 正在休眠中..");
                    Thread.sleep(10000);//被打断 会 抛出异常
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" 被interrupt..");
                }

            }
        }
    }
}
