package IO007;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) {
        String filePath="e:\\a.txt";
        BufferedReader bufferedReader=null;
        String readLen;
        int LineNum=0;
        try {
           bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
             while((readLen=bufferedReader.readLine())!=null){
                 System.out.println((++LineNum)+readLen);
             }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
