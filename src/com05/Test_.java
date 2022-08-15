package com05;
//策略模式
public class Test_ {
    public static void main(String[] args) {
        Hero houYi = new HouYi("她也曾是我的唯一");
        System.out.println(houYi.getName());
        houYi.setSkill(new jiPao());//面向接口
        houYi.useSkill();
    }
}
