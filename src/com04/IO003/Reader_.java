package com04.IO003;

class Test_ {
    public static void main(String[] args) {


        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
//        bufferedReader_.readFiles(10);
       bufferedReader_.readFile();
        //Serializable
        //Externalizable
        //ObjectInputStream
        //ObjectOutputStream
        //这次希望通过 BufferedReader_ 多次读取字符串
//        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
//        bufferedReader_2.readStrings(5);
    }
}

public abstract class Reader_ {
    public void readFile() {
    }

    public void readString() {
    }
//    public abstract void read();
}

 class BufferedReader_ extends Reader_{//包装流 其他两个是节点流

    private Reader_ reader_; //属性是 Reader_类型

    //接收Reader_ 子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void readFile() { //封装一层
        reader_.readFile();
    }

    //让方法更加灵活， 多次读取文件, 或者加缓冲byte[] ....
    public void readFiles(int num) {
        for(int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //扩展 readString, 批量处理字符串数据
    public void readStrings(int num) {
        for(int i = 0; i <num; i++) {
            reader_.readString();
        }
    }

}

 class StringReader_ extends Reader_ {
    public void readString() {
        System.out.println("读取字符串..");
    }

}
 class FileReader_ extends Reader_ {

    public void readFile() {
        System.out.println("对文件进行读取...");
    }
}


