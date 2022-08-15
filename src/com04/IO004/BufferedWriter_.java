package com04.IO004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) {
        String filePath="e:\\ok.txt";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
            bufferedWriter.write("计算机科学与技术");
            bufferedWriter.newLine();//写入换行
            bufferedWriter.write("人工智能");
            bufferedWriter.newLine();
            bufferedWriter.write("软件工程");
            bufferedWriter.newLine();
            bufferedWriter.write("大数据");
            bufferedWriter.close();//一定要关闭流 !!!!!!!!
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
