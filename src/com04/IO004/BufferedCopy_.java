package com04.IO004;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) {
        //  BufferedReader BufferedWriter 是按字符读取的     不要读取二进制的文件 比如视频 图片
        String srcFilePath="e:\\png.txt";
        String desFilePath="e:\\png02.txt";
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            bufferedReader= new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter=new BufferedWriter(new FileWriter(desFilePath));
            String line;
            while ((line=bufferedReader.readLine())!=null) {
                bufferedWriter.write(line);//读一行写一行 写完一行换行
                bufferedWriter.newLine();
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
