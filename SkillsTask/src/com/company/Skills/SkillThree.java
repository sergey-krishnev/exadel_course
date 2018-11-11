package com.company.Skills;

import com.company.Interfaces.SkillDisplayable;

public class SkillThree extends SkillTwo implements SkillDisplayable {
    private String idSubSkillType;

    public String getIdSubSkillType() {
        return idSubSkillType;
    }

    public void setIdSubSkillType(String idSubSkillType) {
        this.idSubSkillType = idSubSkillType;
    }

    public SkillThree(String idSkillType, String nameSkillType, String idSubSkillType) {
        super(idSkillType, nameSkillType);
        this.idSubSkillType = idSubSkillType;
    }
    public void display() {
        System.out.printf("Skill: %s | %s | %s \t \t",getIdSkillType(),getIdSubSkillType(),getNameSkillType());
    }
}
