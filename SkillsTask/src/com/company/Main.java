package com.company;


import com.company.Comparators.LastUsedSkillComparator;
import com.company.Comparators.SkillTypeComparator;
import com.company.Comparators.YearSkillComparator;
import com.company.Skills.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final String CHOICE_SKILL_STATUS = "Announced";
        final String CHOICE_SKILL_TYPE = "Industry / Domain Knowledge";
        final String CHOICE_CHECK = "CHECKED";
        List<Skill> otherskills = new ArrayList<>();
        skillAggregate(otherskills);
        firstCondition(otherskills); //1
        secondCondition(otherskills, CHOICE_SKILL_STATUS, CHOICE_SKILL_TYPE); //2
        thirdCondition(otherskills); //3
        fourthCondition(otherskills, CHOICE_CHECK);

        Comparable<String> searchCriteria = new Comparable<String>() {
            @Override
            public int compareTo(String treeData) {
                if (treeData == null)
                    return 1;
                boolean nodeOk = treeData.contains("210");
                return nodeOk ? 0 : 1;
            }
        };

        System.out.println("/////////5) Search by group of skills, sort by LastUsed  ////////////");
        TreeNode<String> treeRoot = SampleData.getSet1();

        /*

        System.out.println("/////////5) Search by group of skills, sort by LastUsed  ////////////");
        Collections.sort(skills, new LastUsedSkillComparator());

    }
    private static SkillStatus randomizeStatus() {
        Random randZeroOrOne = new Random();
        if (randZeroOrOne.nextBoolean()) return SkillStatus.CHECKED;
        else return SkillStatus.UNCHECKED;
    }*/
    }

    public static void skillAggregate(List<Skill> skills) throws IOException {
        String nameFile = "Data_for_filter2.txt";
        List<String> dataSkill = Files.readAllLines(Paths.get(nameFile), StandardCharsets.UTF_8);
        Random rand = new Random();
        for (Integer i = 0; i < dataSkill.size(); i++) {
            Integer randomLastUsedSkill = rand.nextInt(18) + 2000;
            String[] splitLineSkill = dataSkill.get(i).split(" ; ");
            skills.add(new Skill(i, splitLineSkill[0], "Ivanov Ivan", rand.nextInt(5) + 1,
                    randomLastUsedSkill, new GregorianCalendar(randomLastUsedSkill, rand.nextInt(12), rand.nextInt(28) + 1), splitLineSkill[1], splitLineSkill[2]));
        }
        System.out.println("///////Output of all skills///////");
        for (Skill x : skills) {
            x.display();
        }
    }

    public static void firstCondition(List<Skill> skills) {
        System.out.println("/////////1) Display the list, sorted by SkillType////////////");
        Collections.sort(skills, new SkillTypeComparator());
        for (Skill x : skills) {
            x.display();
        }
    }

    public static void secondCondition(List<Skill> skills, String bySkillStat, String bySkillType) {
        System.out.println("/////////2) Filter of data by SkillType and SkillStatus////////////");
        for (Skill x : skills) {
            if ((x.getSkillStatus().equals(bySkillStat)) && (x.getSkillType().equals(bySkillType)))
                x.display();
        }
    }

    public static void thirdCondition(List<Skill> skills) {
        System.out.println("/////////3) All skills, which have LastCheck, must be displayed by year////////////");
        Collections.sort(skills, new YearSkillComparator());
        for (Skill x : skills) {
            if ((x.getSkillStatus().equals("Unannounced")) && (x.getSkillType().equals("Primary")))
                x.display();
        }
    }

    public static void fourthCondition(List<Skill> skills, String check) {
        System.out.println("/////////4) Filter by Checked/Unchecked////////////");
        if (check.equals("CHECKED")) {
            for (Skill x : skills) {
                if ((x.getSkillStatus().equals("Unannounced")) && (x.getSkillType().equals("Primary")))
                    x.display();
            }
        } else {
            for (Skill x : skills) {
                if (!((x.getSkillStatus().equals("Unannounced")) && (x.getSkillType().equals("Primary"))))
                    x.display();
            }

        }
    }

}
