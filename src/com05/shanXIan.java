package com05;

public class shanXIan implements Skill{
    @Override
    public void UseSkill() {
        this.shanXianUse();
    }
    public void shanXianUse(){
        System.out.println("闪现 瞬移一定距离..");
    }
}
