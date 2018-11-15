package com.company.Skills;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class FilteredSkillList {
    List<Skill> skillList;
    String skillType, skillStatus;
    Comparator<Skill> comparator;

    public List<Skill> getSkillList() {
        return skillList;
    }
    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
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
    public FilteredSkillList(String checked) {
        if (Objects.equals(checked, "CHECKED")) {

        }
    }

    public FilteredSkillList(List<Skill> skillList, Comparator<Skill> comparator) {
        Collections.sort(skillList,comparator);
        this.skillList = skillList;
        this.comparator = comparator;
        this.skillType = "Primary";
        this.skillStatus = "Unannounced";
    }

    public FilteredSkillList(List<Skill> skillList, String skillType, String skillStatus) {
        this.skillList = skillList;
        this.skillType = skillType;
        this.skillStatus = skillStatus;
    }
    public void display() {
        System.out.println("//////////Filter by SkillType and SkillStatus");
        for (Skill x : skillList) {
            if (x.checkedSkill(skillStatus,skillType))
                x.display();
        }
    }
}
