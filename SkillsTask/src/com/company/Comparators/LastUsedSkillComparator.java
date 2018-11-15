package com.company.Comparators;

import com.company.Skills.Skill;

import java.util.Comparator;

public class LastUsedSkillComparator implements Comparator<Skill>{
    public int compare(Skill a, Skill b){

        return a.getLastUsedSkill().compareTo(b.getLastUsedSkill());
    }}
