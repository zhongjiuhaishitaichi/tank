package com02.Thread;

public class CPUNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpu = runtime.availableProcessors();
        System.out.println("电脑cpu核心数: "+cpu);
    }
}
