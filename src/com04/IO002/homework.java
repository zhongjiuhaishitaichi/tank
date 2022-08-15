package com04.IO002;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class homework {
    public static void main(String[] args) {

    }
    @Test
    public void InOut(){
        String srcFilePath="e:\\pass.png";
        String derFilePath="e:\\pass2.png";
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream= new  FileInputStream(srcFilePath);//输入流 给程序
            fileOutputStream=new FileOutputStream(derFilePath,true); //输出流 写进电脑
            byte[] bytes = new byte[1024];
            int readLength=0;
            //一次读取最多1024个字节
            while((readLength=fileInputStream.read(bytes))!=-1){//一边读 一边写
                fileOutputStream.write(bytes,0,readLength);//从bytes这个数组里  从0 开始 读取 长度为readLength
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
