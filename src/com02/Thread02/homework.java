package com02.Thread02;

import java.util.Locale;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        B b = new B(a);
        b.start();
    }
}
class A extends Thread{
    private boolean loop=true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while(loop){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("A 线程结束...");
    }
}
class B extends Thread{
    private A a;
    private Scanner scanner= new Scanner(System.in);
    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
       while(true){
           char key=scanner.next().toUpperCase().charAt(0); //首字母转化为大写
           if (key=='Q'){
               a.setLoop(false);//在这里控制线程
               System.out.println("B线程结束运行...");
               break;
           }
       }
    }
}
