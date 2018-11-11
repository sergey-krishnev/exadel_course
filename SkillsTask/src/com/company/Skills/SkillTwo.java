package com.company.Skills;

import com.company.Interfaces.SkillDisplayable;

public class SkillTwo extends SkillOne implements SkillDisplayable {
    private String nameSkillType;

    public String getNameSkillType() {
        return nameSkillType;
    }

    public void setNameSkillType(String nameSkillType) {
        this.nameSkillType = nameSkillType;
    }

    public SkillTwo(String idSkillType, String nameSkillType) {
        super(idSkillType);
        this.nameSkillType = nameSkillType;
    }
    public void display() {
        System.out.printf("Skill: %s | %s \t \t",getIdSkillType(),getNameSkillType());
    }
}
