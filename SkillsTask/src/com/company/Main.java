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

    private ISkillFilter filter;

    private IDisplay iDisplay;

    public static void main(String[] args) throws IOException {

        SkillAggregate skillAggregate = new SkillAggregate(new SkillsFileReader("Data_for_filter2.txt"));

        IDisplay skillDisplay = new DisplayImpl();

        ISkillFilter filter = new SkillFilterImpl(skillAggregate.getSkills());

        skillDisplay.display(filter.findAll());

        skillDisplay.display(filter.findByLastCheck(new Date()));


//        final String CHOICE_SKILL_STATUS = "Announced";
//        final String CHOICE_SKILL_TYPE = "Industry / Domain Knowledge";
//        final String CHOICE_CHECK = "CHECKED";
//        List<Skill> otherskills = new ArrayList<>();
//        SkillsFileReader skillsFileReader = new SkillsFileReader("Data_for_filter2.txt");
//        SkillAggregate skillAggregate = new SkillAggregate(skillsFileReader);
//        skillAggregate.display();
//
//        SortedSkillList sortedSkillList = new SortedSkillList(skillAggregate.getSkills(),new SkillTypeComparator());
//        sortedSkillList.display(); //1
//
//
//
//        FilteredSkillList filteredSkillList = new FilteredSkillList(skillAggregate.getSkills(),CHOICE_SKILL_STATUS,CHOICE_SKILL_TYPE);
//        filteredSkillList.display(); //2
//
//        FilteredSkillList lastCheckedFilteredSkillList = new FilteredSkillList(skillAggregate.getSkills(),new YearSkillComparator());
//        lastCheckedFilteredSkillList.display(); //3
//
//        FilteredSkillList last4CheckedFilteredSkillList = new FilteredSkillList(skillAggregate.getSkills(),new YearSkillComparator(), CHOICE_CHECK);
//
//        all - last4CheckedFilteredSkillList



        //skillAggregate(otherskills);
       // firstCondition(otherskills); //1
       // secondCondition(otherskills, CHOICE_SKILL_STATUS, CHOICE_SKILL_TYPE); //2
       // thirdCondition(otherskills); //3
      //  fourthCondition(otherskills, CHOICE_CHECK); //4
      //  fifthCondition(otherskills, CHOICE_SKILL_STATUS, CHOICE_SKILL_TYPE); //5
    }

    /* public static void skillAggregate(List<Skill> skills) throws IOException {
        String nameFile = "Data_for_filter2.txt";
        List<String> dataSkill = Files.readAllLines(Paths.get(nameFile), StandardCharsets.UTF_8);
        Random rand = new Random();
        for (Integer i = 0; i < dataSkill.size(); i++) {
            Integer randomLastUsedSkill = rand.nextInt(18) + 2000;
            String[] splitLineSkill = dataSkill.get(i).split(" ; ");
            GregorianCalendar gregorianCalendar = new GregorianCalendar(randomLastUsedSkill, rand.nextInt(12), rand.nextInt(28) + 1);
            skills.add(new Skill(i, splitLineSkill[0], "Ivanov Ivan", rand.nextInt(5) + 1,
                    randomLastUsedSkill, gregorianCalendar.getTime(), splitLineSkill[1], splitLineSkill[2]));
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
    public static void fifthCondition(List<Skill> skills, String bySkillStat, String bySkillType) {
        System.out.println("/////////5) Search by group of skills (SkillStatus and SkillType), sort by LastUsed  ////////////");
        List<Skill> bySkillStatus = new ArrayList<>();
        List<String> nameSkillList = new ArrayList<>();
        List<String> nameSkillListLastChild = new ArrayList<>();

        for (Skill skill : skills) {
            if((skill.getSkillStatus().equals(bySkillStat)) && (skill.getSkillType().equals(bySkillType))) // Condition of Skill Status and Skill Type
                bySkillStatus.add(skill);
        }
        Collections.sort(bySkillStatus, new SkillTypeComparator().thenComparing(new LastUsedSkillComparator()));
        for (Skill x : bySkillStatus) {
            nameSkillList.add(x.getNameSkill());
        }
        for (String x : nameSkillList) {
            String[] separateBySlash = x.split(" / ");
            nameSkillListLastChild.add(separateBySlash[separateBySlash.length-1]);
        }

        SkillTreeNode skillTreeNode = new SkillTreeNode(nameSkillList);
        StringBuffer skillTreeNodeLine = editLine(skillTreeNode.toString());

        for (Integer i = 0 ; i < nameSkillListLastChild.size(); i++) {
            skillTreeNodeLine.insert(skillTreeNodeLine.indexOf(nameSkillListLastChild.get(i))+ nameSkillListLastChild.get(i).length(),
                    bySkillStatus.get(i).displayToListString());
        }

        System.out.println(skillTreeNodeLine);
    }


    public static String colTab(Integer col) {
        String value ="";
        for (Integer i = 0; i < col; i++) {
            value += " \t ";
        }
        return "\n " + value;
    }
    public static StringBuffer editLine(String line) {
        StringBuffer bufferLine = new StringBuffer(line);
        Integer changer = 0;
        while ((bufferLine.indexOf("{")!=-1) && bufferLine.indexOf("}")!=-1) {
            if (bufferLine.indexOf("{") < bufferLine.indexOf("}")) {
                Integer position = bufferLine.indexOf("{");
                bufferLine.setCharAt(position,' ');
                bufferLine.insert(position,colTab(changer));
                changer++;
            } else
            if (bufferLine.indexOf("}")!=-1) {
                Integer position = bufferLine.indexOf("}");
                bufferLine.setCharAt(position,' ');
                bufferLine.insert(position,colTab(changer));
                changer--;
            }
        deleteElement(bufferLine,"[");
        deleteElement(bufferLine,"]");
        deleteElement(bufferLine,",");
        }
        deleteElement(bufferLine,"}");
        return bufferLine;
    }
    public static StringBuffer deleteElement (StringBuffer deletedLine, String element) {
        while (deletedLine.indexOf(element)!=-1) {
            Integer positionLeft = deletedLine.indexOf(element);
            deletedLine.setCharAt(positionLeft,'\b');
        }
        return deletedLine;
    }
    */
}
