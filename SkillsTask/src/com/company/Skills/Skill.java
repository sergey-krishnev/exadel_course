package com.company.Skills;

import com.company.Interfaces.SkillDisplayable;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Skill {
    private String checkedBySkill;
    private Integer yearSkill,lastUsedSkill;
    private GregorianCalendar lastCheckSkill;
    private SkillDisplayable skillType;
    private SkillStatus skillStatus;


    public String getCheckedBySkill() {
        return checkedBySkill;
    }

    public void setCheckedBySkill(String checkedBySkill) {
        this.checkedBySkill = checkedBySkill;
    }

    public Integer getYearSkill() {
        return yearSkill;
    }

    public void setYearSkill(Integer yearSkill) {
        this.yearSkill = yearSkill;
    }

    public Integer getLastUsedSkill() {
        return lastUsedSkill;
    }

    public void setLastUsedSkill(Integer lastUsedSkill) {
        this.lastUsedSkill = lastUsedSkill;
    }

    public GregorianCalendar getLastCheckSkill() {
        return lastCheckSkill;
    }

    public void setLastCheckSkill(GregorianCalendar lastCheckSkill) {
        this.lastCheckSkill = lastCheckSkill;
    }

    public SkillDisplayable getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillDisplayable skillType) {
        this.skillType = skillType;
    }

    public SkillStatus getSkillStatus() {
        return skillStatus;
    }

    public void setSkillStatus(SkillStatus skillStatus) {
        this.skillStatus = skillStatus;
    }

    public Skill(String checkedBySkill, Integer yearSkill, Integer lastUsedSkill, GregorianCalendar lastCheckSkill, SkillDisplayable skillType,SkillStatus skillStatus) {
        this.checkedBySkill = checkedBySkill;
        this.yearSkill = yearSkill;
        this.lastUsedSkill = lastUsedSkill;
        this.lastCheckSkill = lastCheckSkill;
        this.skillType = skillType;
        this.skillStatus = skillStatus;
    }

    public void display() {
        if (getSkillStatus() == SkillStatus.CHECKED) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/y");
            getSkillType().display();
            System.out.printf("Years: %s \t " +
                            "Last used in: %s \t Last check: %s \t Checked by: %s \n",
                    getYearSkill(), getLastUsedSkill(),
                    dateFormat.format(getLastCheckSkill().getTime()), getCheckedBySkill());
        } else {
            getSkillType().display();
            System.out.printf("Years: %s \t " +
                            "Last used in: %s \t Last check: \t Checked by: \n",
                    getYearSkill(), getLastUsedSkill());
        }
    }
}
