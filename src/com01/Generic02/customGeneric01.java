package com01.Generic02;
@SuppressWarnings({"all"})
public class customGeneric01 {
    public static void main(String[] args) {
        Tiger<String, Integer, Double> tiger = new Tiger<String, Integer,Double>("jack","123",123,123.123);
        System.out.println(tiger.f());
    }
}
//  自定义泛型类
class Tiger<T,K,R>{
    // 可以是多个泛型  普通成员类型才能是泛型 属性 方法
    // 数组也不能用泛型
    // 因为静态是和类相关的 在类加载的时候 对象还没创建 所以 静态的属性和方法使用了泛型 jvm就不知道怎么初始化了 泛型只是一个代表标识符
    private String name;
    T m;
    K n;
    R l;

    public Tiger(String name, T m, K n, R l) {
        this.name = name;
        this.m = m;
        this.n = n;
        this.l = l;
    }
    public T f(){
        return (T) "软件工程";
    }

}