package com01.Generic02;

public class InterfaceGeneric {
    public static void main(String[] args) {

    }
}

class BB implements IUsb<Integer, Float> {//也是替换
    @Override
    public Float get(Integer u) {
        return null;
    }

    @Override
    public void hi(Integer i) {

    }

    @Override
    public void run(Integer t1, Float u1) {

    }
}

interface IUsb<T, R> {
    R get(T u);

    void hi(T i);

    void run(T t1, R u1);

    default R method(T s) {// 有了 default就能是实现具体的方法体
        return null;
    }
}

class CC implements IUsb{   //默认是Object类型  但是不要这样写

    @Override
    public Object get(Object u) {
        return null;
    }

    @Override
    public void hi(Object i) {

    }

    @Override
    public void run(Object t1, Object u1) {

    }
}
interface IA extends IUsb<String, Double> {
}

class AA implements IA {
    @Override
    public Double get(String u) {  //继承了接口 自动转化成你定义的类型 分别 用String Double 替换T R
        return null;
    }

    @Override
    public void hi(String i) {

    }

    @Override
    public void run(String t1, Double u1) {

    }
}
