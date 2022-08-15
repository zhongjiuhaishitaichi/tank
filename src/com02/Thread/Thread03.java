package com02.Thread;

//模拟代理模式 体会线程的启动
public class Thread03 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("我是小老虎..");
    }
}
//模拟Thread类
class ThreadProxy implements Runnable {
    private Runnable target = null;//属性  类型是Runnable


    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定 绑定了运行类型tiger
        }
    }

    public ThreadProxy(Runnable target) {//构造器 向上转型 可以接受实现接口的类
        this.target = target;
    }

    public void start() {
        start0();//真正实现多线程
    }

    public void start0() {
        run();
    }
}