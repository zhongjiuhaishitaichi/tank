package com04.Transformation_;

import java.io.*;
//字节转字符
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String str="e:\\a.txt";
        // 字节流转化为字符流 再转为处理流 提高效率 解决乱码问题
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "gbk"));
        String readLen;
        while((readLen=bufferedReader.readLine())!=null){
            System.out.println(readLen);
        }
        bufferedReader.close();
    }
}
