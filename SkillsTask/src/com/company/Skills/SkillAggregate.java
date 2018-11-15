package com.company.Skills;

import java.util.ArrayList;
import java.util.List;

public class SkillAggregate {
    private List<Skill> skills = new ArrayList<>();
    private SkillsFileReader skillsFileReader;

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public SkillsFileReader getSkillsFileReader() {
        return skillsFileReader;
    }

    public void setSkillsFileReader(SkillsFileReader skillsFileReader) {
        this.skillsFileReader = skillsFileReader;
    }

    public SkillAggregate(SkillsFileReader skillsFileReader) {
        for (int i = 0 ; i < skillsFileReader.getSizeFile() ; i++) {
            skills.add(new Skill(i,skillsFileReader.getNameSkillList().get(i),
                    skillsFileReader.getSkillTypeList().get(i),skillsFileReader.getSkillStatusList().get(i)));
        }
        this.skillsFileReader = skillsFileReader;
    }
//    public void display() {
//        System.out.println("///////Output of all skills///////");
//        for (Skill x : skills) {
//            x.display();
//        }
//    }
}
