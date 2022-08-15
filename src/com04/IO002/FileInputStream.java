package com04.IO002;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream {

    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        int read = 0;
        String filePath = "e:\\hello.txt";
        java.io.FileInputStream fileInputStream = null;
        try {
            fileInputStream = new java.io.FileInputStream(filePath);//io包里的FileInputStream  形成输入流
            //从该输入流读取一个字节的数据(一个一个读  所以如果是汉字的话 UTF-8是三个字节 会乱码) 如果没有输入可用 此方法讲阻止
            while ((read = fileInputStream.read()) != -1) {//读取文件 返回-1 读取完毕
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      finally{
            fileInputStream.close();//流关闭 释放资源
        }
    }
    @Test
    public void readFile02() throws IOException {
        byte[] bytes = new byte[8];//字节数组  一次读取八个
        int byteLength=0;
        String filePath = "e:\\hello.txt";
        java.io.FileInputStream fileInputStream = null;
        try {
            fileInputStream = new java.io.FileInputStream(filePath);//io包里的FileInputStream  形成输入流
            //八个字节为一组 输出       如果没有输入可用 此方法讲阻止
            while (( byteLength= fileInputStream.read(bytes)) != -1) {//读取文件 返回-1 读取完毕
                System.out.println(new String(bytes,0,byteLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            fileInputStream.close();//流关闭 释放资源
        }
    }
}
