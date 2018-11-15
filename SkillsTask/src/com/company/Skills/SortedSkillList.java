package com.company.Skills;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedSkillList {
    List<Skill> skillList;
    Comparator<Skill> comparator;
    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public SortedSkillList(List<Skill> skillList, Comparator<Skill> comparator) {
        Collections.sort(skillList,comparator);
        this.skillList = skillList;
        this.comparator = comparator;
    }
    public void display() {
        System.out.println("////SortedList");
        for (Skill x : skillList) {
            x.display();
        }
    }
}
