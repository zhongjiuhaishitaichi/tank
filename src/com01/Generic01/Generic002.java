package com01.Generic01;

public class Generic002 {
    public static void main(String[] args) {
        Dog<A> aDog = new Dog<>(new A());
        aDog.f();
        Dog<A> aDog1 = new Dog<>(new B());
        aDog1.f();
    }
}
class A{}
class B extends A{}
class Dog<E>{
    private E e;

    public Dog(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
    public void f(){
        System.out.println(e.getClass());
    }
}
