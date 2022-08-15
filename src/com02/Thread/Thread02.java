package com02.Thread;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //可以把实现了Runnable接口的类 放进线程里面 就是需要新建一个线程模式
        //这里不能直接调用run 方法 run只是普通方法  真正开启线程的是start0() 方法 由JVM调用
        // 也不能直接用start方法 因为只是继承了接口 并没有start方法
        Thread thread = new Thread(dog);
        thread.start();
    }
}
class Dog implements Runnable {
    int count=0;
    @Override
    public void run() {
        while(true){
            System.out.println("狗叫"+(++count)+ Thread.currentThread().getName());
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
