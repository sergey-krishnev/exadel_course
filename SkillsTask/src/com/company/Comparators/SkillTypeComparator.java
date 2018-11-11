package com.company.Comparators;

import com.company.Skills.Skill;

import java.util.Comparator;

public class SkillTypeComparator implements Comparator<Skill> {
    public int compare(Skill a, Skill b){

        return (a.getSkillType().getIdSkillType()).compareTo(b.getSkillType().getIdSkillType());
    }
}
