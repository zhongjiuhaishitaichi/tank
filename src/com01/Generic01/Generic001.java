package com01.Generic01;

public class Generic001 {
    public static void main(String[] args) {
        Person<Integer> comp = new Person<>(123);
        System.out.println(comp.getS());
    }
}
//可以给类<E>换成不同的类型 以后的E就是对应的类型
class Person<E>{
    E s;

    public Person(E s) {
        this.s = s;
    }

    public E getS() {
        return s;
    }

    public void setS(E s) {
        this.s = s;
    }
}