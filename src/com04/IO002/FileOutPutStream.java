package com04.IO002;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStream {
    public static void main(String[] args) {

    }
    @Test
    public void OutPutStream() {
         String filePath="e:\\swx.txt";
         FileOutputStream fileOutputStream=null;
         //new FileOutputStream(filePath) 写入内容的时候是覆盖原来的内容
        // new FileOutputStream(filePath,true) 是追加的构造器  追加内容
        try {
            fileOutputStream=new FileOutputStream(filePath);//输入流
            String str="swx world!";
            //这个方法可以把字符串转化成字节数组
          /*  fileOutputStream.write(str.getBytes());*/
            //与上面等价
          fileOutputStream.write(str.getBytes(),1,str.length()-1);//数组的长度-1
            fileOutputStream.write(str.getBytes(),2,5);//写入指定的字符长度 length
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
