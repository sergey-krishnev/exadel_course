package com.company.Skills;

import java.text.SimpleDateFormat;
import java.util.*;

public class Skill {
    private static String standartCheckedBySkill = "Ivanov Ivan";
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y");


    private String nameSkill,checkedBySkill;
    private Integer idSkill,yearSkill,lastUsedSkill;
    private Date lastCheckSkill;
    private String skillType;
    private String skillStatus;

    public String getNameSkill() { return nameSkill; }

    public void setNameSkill(String nameSkill) { this.nameSkill = nameSkill; }

    public String getLastChildSkill() {
        String[] splitLineSkill = nameSkill.split(" / ");
        return splitLineSkill[2];
    }

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

    public Date getLastCheckSkill() {
        return lastCheckSkill;
    }

    public void setLastCheckSkill(Date lastCheckSkill) {
        this.lastCheckSkill = lastCheckSkill;
    }

    public String getLastCheckSkillFormatted() {
        if (lastCheckSkill == null) {
            return "";
        } else {
            return sdf.format(lastCheckSkill);
        }
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

    public Skill(Integer idSkill, String nameSkill, String skillType, String skillStatus) {
        Random rand = new Random();
        Integer randomLastUsedSkill = rand.nextInt(18) + 2000;
        this.idSkill = idSkill;
        this.nameSkill = nameSkill;
        this.skillType = skillType;
        this.skillStatus = skillStatus;
        yearSkill = rand.nextInt(5) + 1;
        lastUsedSkill = randomLastUsedSkill;
        if (checkedSkill()) {
            checkedBySkill = standartCheckedBySkill;
            GregorianCalendar gc = new GregorianCalendar(randomLastUsedSkill, rand.nextInt(12), rand.nextInt(28) + 1);
            this.lastCheckSkill = gc.getTime();
        } else {
            checkedBySkill = "";
            lastCheckSkill = null;

        }
    }
    public Skill(Integer idSkill, String nameSkill,String checkedBySkill, Integer yearSkill, Integer lastUsedSkill,
                 Date lastCheckSkill, String skillType,String skillStatus) {
        this.idSkill = idSkill;
        this.nameSkill = nameSkill;
        this.checkedBySkill = checkedBySkill;
        this.yearSkill = yearSkill;
        this.lastUsedSkill = lastUsedSkill;
        this.lastCheckSkill = lastCheckSkill;
        this.skillType = skillType;
        this.skillStatus = skillStatus;
    }
    public Skill(String nameSkill,Integer yearSkill, Integer lastUsedSkill) {
        this.nameSkill = nameSkill;
        this.yearSkill = yearSkill;
        this.lastUsedSkill = lastUsedSkill;
    }
    public boolean checkedSkill() {
        return checkedSkill("Unannounced","Primary");
    }
    public boolean checkedSkill(String skillStatus, String skillType) {
        if (this.skillStatus.equals(skillStatus) && this.skillType.equals(skillType)) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
            System.out.printf("SkillType: %s \t Skill: %s \t Years: %s \t " +
                            "Last used in: %s \t Last check: %s \t Checked by: %s \n",
                    getSkillType(),getNameSkill(),getYearSkill(), getLastUsedSkill(),
                    getLastCheckSkillFormatted(), getCheckedBySkill());
    }
    public String displayToListString () {
        return "\t Years: " + getYearSkill() + " \t Last used in: "+ getLastUsedSkill() + " \t Last check: "
                + getLastCheckSkillFormatted() + " \t Checked by: " + getCheckedBySkill();
    }
}
