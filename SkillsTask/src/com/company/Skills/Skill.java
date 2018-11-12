package com.company.Skills;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Skill {
    private String nameSkill,checkedBySkill;
    private Integer idSkill,yearSkill,lastUsedSkill;
    private GregorianCalendar lastCheckSkill;
    private String skillType;
    private String skillStatus;

    public String getNameSkill() { return nameSkill; }

    public void setNameSkill(String nameSkill) { this.nameSkill = nameSkill; }

    public Integer getIdSkill() { return idSkill; }

    public void setIdSkill(Integer idSkill) { this.idSkill = idSkill; }

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

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillStatus() {
        return skillStatus;
    }

    public void setSkillStatus(String skillStatus) {
        this.skillStatus = skillStatus;
    }

    public Skill(Integer idSkill, String nameSkill,String checkedBySkill, Integer yearSkill, Integer lastUsedSkill, GregorianCalendar lastCheckSkill, String skillType,String skillStatus) {
        this.idSkill = idSkill;
        this.nameSkill = nameSkill;
        this.checkedBySkill = checkedBySkill;
        this.yearSkill = yearSkill;
        this.lastUsedSkill = lastUsedSkill;
        this.lastCheckSkill = lastCheckSkill;
        this.skillType = skillType;
        this.skillStatus = skillStatus;
    }

    public void display() {
        if (getSkillStatus().equals("Unannounced") && getSkillType().equals("Primary")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/y");
            System.out.printf("SkillType: %s \t Skill: %s \t Years: %s \t " +
                            "Last used in: %s \t Last check: %s \t Checked by: %s \n",
                    getSkillType(),getNameSkill(),getYearSkill(), getLastUsedSkill(),
                    dateFormat.format(getLastCheckSkill().getTime()), getCheckedBySkill());
        } else {
            System.out.printf("SkillType: %s \t Skill: %s \t Years: %s \t " +
                            "Last used in: %s \t Last check: \t Checked by: \n",
                    getSkillType(),getNameSkill(),getYearSkill(), getLastUsedSkill());
        }
    }
}
