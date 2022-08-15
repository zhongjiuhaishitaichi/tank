package com01.Generic02;

import org.junit.jupiter.api.Test;

public class JUnit {
    public static void main(String[] args) {

    }
    // JUnit 测试  使用之前需要引包 在每个方法之前都要加@Test
    @Test
    public void m1(){
        System.out.println("m1方法..");
    }
    @Test
    public void m2(){
        System.out.println("m2方法...");
    }
}
