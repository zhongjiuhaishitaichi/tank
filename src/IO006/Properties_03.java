package IO006;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //setProperty 方法 写入信息
       properties.setProperty("charset", "utf-8");
       properties.setProperty("user", "swx");
       //根据key  可以修改value
       properties.setProperty("pwd", "123123abc");
        //把k-v 存储
        //第二个参数就是注释
        properties.store(new FileOutputStream("E:\\Chapter03\\untitled\\src\\mysql02.properties"),"swx MySQL");
        System.out.println("保存成功..");

    }
}
