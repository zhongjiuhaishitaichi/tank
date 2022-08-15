package com04.IO001;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    public void create(){
        File file = new File("e:\\");
        String fileName="news.txt";
        File file1 = new File(file, fileName);
        try {
            file1.createNewFile();
            System.out.println("创建成功..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void create02(){
       String parentPath="e:\\";
        String fileName="news02.txt";
        File file1 = new File(parentPath, fileName);
        try {
            file1.createNewFile();
            System.out.println("创建成功..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
