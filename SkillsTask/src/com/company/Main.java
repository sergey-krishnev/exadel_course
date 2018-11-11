package com.company;


import com.company.Comparators.LastUsedSkillComparator;
import com.company.Comparators.SkillTypeComparator;
import com.company.Comparators.YearSkillComparator;
import com.company.Interfaces.SkillDisplayable;
import com.company.Skills.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final SkillStatus CHOICE_SKILL_STATUS = SkillStatus.CHECKED;
        final String CHOICE_SKILL_TYPE = "Architecture";

        String nameFile = "Data_for_filter.txt";
        List<String> dataSkillTypes = Files.readAllLines(Paths.get(nameFile), StandardCharsets.UTF_8);
        List<Skill> skills = new ArrayList<>();
        Random rand = new Random();
        for(String line: dataSkillTypes){
            String[] splitLine = line.split(" / ");
            Integer randomLastUsedSkill = rand.nextInt(18) + 2000;
            SkillDisplayable skillDisplayable;
            if (splitLine.length == 1) {
                skillDisplayable = new SkillOne(splitLine[0]);
            } else if (splitLine.length == 2){
                skillDisplayable = new SkillTwo(splitLine[0], splitLine[1]);
            } else {
                skillDisplayable = new SkillThree(splitLine[0], splitLine[1], splitLine[2]);
            }
            skills.add(new Skill("Ivanov Ivan", rand.nextInt(5) + 1, randomLastUsedSkill,
                    new GregorianCalendar(randomLastUsedSkill, rand.nextInt(12), rand.nextInt(28) + 1), skillDisplayable, randomizeStatus()));
        }
        System.out.println("/////////1) Display the list, sorted by SkillType////////////");
        Collections.sort(skills, new SkillTypeComparator());
        for(Skill x: skills)
        {
            x.display();
        }
        System.out.println("/////////2) Filter of data by SkillType and SkillStatus////////////");
        for(Skill x: skills)
        {
            if ((x.getSkillStatus() == CHOICE_SKILL_STATUS) && ((x.getSkillType().getIdSkillType()).equals(CHOICE_SKILL_TYPE)))
            x.display();
        }
        System.out.println("/////////3) All skills, which have LastCheck, must be displayed by year////////////");
        Collections.sort(skills, new YearSkillComparator());
        for(Skill x: skills)
        {
            if ((x.getSkillStatus() == SkillStatus.CHECKED)) x.display();
        }
        System.out.println("/////////4) Filter by Checked/Unchecked////////////");
        for(Skill x: skills)
        {
            if (x.getSkillStatus() == CHOICE_SKILL_STATUS)
                x.display();
        }
        System.out.println("/////////5) Search by group of skills, sort by LastUsed  ////////////");
        Collections.sort(skills, new LastUsedSkillComparator());

    }
    private static SkillStatus randomizeStatus() {
        Random randZeroOrOne = new Random();
        if (randZeroOrOne.nextBoolean()) return SkillStatus.CHECKED;
        else return SkillStatus.UNCHECKED;
    }
}
