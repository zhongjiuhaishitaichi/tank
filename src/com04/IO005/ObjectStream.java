package com04.IO005;

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) throws IOException {
        String str="e:\\hello.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(str));
        //这里都会进行自动装箱成类 Integer等  因为他们继承了那个接口
        objectOutputStream.writeUTF("软件工程");
        objectOutputStream.write(10);
        objectOutputStream.writeDouble(1.1);
        objectOutputStream.writeChar('a');
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeObject(new Dog(10,"小红"));
        objectOutputStream.close();
    }
}
class Dog implements Serializable{
    private int age;
    private String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
}