package com05;

public  class Hero {
    private String name;
    private Skill skill;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public void useSkill(){
        skill.UseSkill();
    }
}
