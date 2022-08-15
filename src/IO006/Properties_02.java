package IO006;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties_02 {
    public static void main(String[] args) throws IOException {
        //用properties 来读取文件
        Properties properties = new Properties();
        //加载指定的配置文件
        properties.load(new FileReader("E:\\Chapter03\\untitled\\src\\mysql.properties"));
        //显示K-V的所有内容
        properties.list(System.out);
        String user = properties.getProperty("user");//该方法通过获得key 输出value
        String pwd = properties.getProperty("pwd");
        System.out.println(user);
        System.out.println(pwd);

    }
}
