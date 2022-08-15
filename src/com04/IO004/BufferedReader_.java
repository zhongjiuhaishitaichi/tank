package com04.IO004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) {
        String file="e:\\hi.txt";
        //创建
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));//底层还是FileReader 封装成BufferedReader
            String line;
            while((line=bufferedReader.readLine())!=null){//readLine 一行一行读
                System.out.println(line);
            }
            bufferedReader.close();//关闭处理流  节点流会自动被关闭
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
