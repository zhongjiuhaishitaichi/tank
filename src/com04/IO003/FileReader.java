package com04.IO003;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        String filePath = "e:\\story.txt";
        java.io.FileReader fileReader = null;
        int data = 0;
        try {
            fileReader = new java.io.FileReader(filePath);
            while ((data = fileReader.read()) != -1) {//一个字符一个字符的读 data就是内容
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void FileReader02() {
        String filePath = "e:\\story.txt";
        java.io.FileReader fileReader = null;
        int readLen = 0;
        char[] chars = new char[8];//字符
        try {
            fileReader = new java.io.FileReader(filePath);
            while ((readLen = fileReader.read(chars)) != -1) {// 按照bytes数组 为一组读取
                System.out.print(new String(chars, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
