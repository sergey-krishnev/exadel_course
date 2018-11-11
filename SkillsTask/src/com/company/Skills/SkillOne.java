package com.company.Skills;

import com.company.Interfaces.SkillDisplayable;

public class SkillOne implements SkillDisplayable {
    private String idSkillType;

    public String getIdSkillType() {
        return idSkillType;
    }

    public void setIdSkillType(String idSkillType) {
        this.idSkillType = idSkillType;
    }

    public SkillOne(String idSkillType) {
        this.idSkillType = idSkillType;
    }
    public void display() {
        System.out.printf("Skill: %s \t \t",getIdSkillType());
    }
}
