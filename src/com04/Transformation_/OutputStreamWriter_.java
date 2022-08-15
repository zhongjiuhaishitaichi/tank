package com04.Transformation_;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath="e:\\swx.txt";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "utf8");
        outputStreamWriter.write("时文宣");
        outputStreamWriter.close();
     

    }
}
