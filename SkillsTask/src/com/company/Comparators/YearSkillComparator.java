package com.company.Comparators;

import com.company.Skills.Skill;

import java.util.Comparator;

public class YearSkillComparator implements Comparator<Skill> {
    public int compare(Skill a, Skill b) {

        return a.getYearSkill().compareTo(b.getYearSkill());
    }
}
