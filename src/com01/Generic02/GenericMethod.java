package com01.Generic02;

import java.util.ArrayList;

public class GenericMethod {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("奔驰", 1000);//调用方法的时候 传入参数的时候就会确定类型  装箱
        phone<ArrayList, Double> phone = new phone<>();
        phone.hello(new ArrayList(),"123123123");

    }
}

class Car {//普通类

    public void run() {//普通方法
        System.out.println("run");
    }

    public <T, R> void fly(T t, R r) {
        System.out.println("起飞");
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class phone<T, R> {
    public void call() {
    }

    public <U, M> void eat(U u, M m) {
    }
   //这个 不是泛型方法  只是用到了这个类声明的泛型
    public void hi(T t) {
    }
    public <K> void hello(T t,K k){//也可以使用自己定义的泛型
        System.out.println(t.getClass());
        System.out.println(k.getClass());
    }
}
