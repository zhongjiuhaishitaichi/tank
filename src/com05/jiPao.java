package com05;

public class jiPao implements Skill{
    @Override
    public void UseSkill() {
        this.JiPaoUse();
    }
    public void JiPaoUse(){
        System.out.println("疾跑 增加移动速度..");
    }
}
