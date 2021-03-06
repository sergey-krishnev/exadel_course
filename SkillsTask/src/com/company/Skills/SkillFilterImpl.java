package com.company.Skills;

import java.util.*;

public class SkillFilterImpl implements ISkillFilter {
    private List<Skill> skills;

    public SkillFilterImpl(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public List<Skill> findAll() {
        return skills;
    }

    @Override
    public List<Skill> findAll(Comparator<Skill> comparator) {
        Collections.sort(skills,comparator);
        return  skills;
    }

    @Override
    public List<Skill> findByType(String type) {
        List<Skill> byType = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.getSkillType().equals(type))
                byType.add(skill);
        }
        return byType;
    }

    @Override
    public List<Skill> findByType(String type, Comparator<Skill> comparator) {
        Collections.sort(skills,comparator);
        List<Skill> byType = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.getSkillType().equals(type))
                byType.add(skill);
        }
        return byType;
    }

    @Override
    public List<Skill> findByStatus(String status) {
        List<Skill> byStatus = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.getSkillStatus().equals(status))
                byStatus.add(skill);
        }
        return byStatus;
    }

    @Override
    public List<Skill> findByStatus(String status, Comparator<Skill> comparator) {
        Collections.sort(skills,comparator);
        List<Skill> byStatus = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.getSkillStatus().equals(status))
                byStatus.add(skill);
        }
        return byStatus;
    }

    @Override
    public List<Skill> findByTypeAndStatus(String type, String status) {
        List<Skill> byTypeAndStatus = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.checkedSkill(status,type))
                byTypeAndStatus.add(skill);
        }
        return byTypeAndStatus;
    }

    @Override
    public List<Skill> findByTypeAndStatus(String type, String status, Comparator<Skill> comparator) {
        Collections.sort(skills,comparator);
        List<Skill> byTypeAndStatus = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.checkedSkill(status,type))
                byTypeAndStatus.add(skill);
        }
        return byTypeAndStatus;
    }

    @Override
    public List<Skill> findByCheck(String check) {
        List<Skill> byCheck = new ArrayList<>();
        if(check.equals("CHECKED")) {
            for (Skill skill : skills) {
                if (skill.checkedSkill())
                    byCheck.add(skill);
            }
            return byCheck;
        } else {
            for (Skill skill : skills) {
                if (!(skill.checkedSkill()))
                    byCheck.add(skill);
            }
            return byCheck;
        }
    }

    @Override
    public List<Skill> findBySkills(List<Skill> groupSkills, Comparator<Skill> comparator) {
        List<Skill> bySkill = new ArrayList<>();
        Boolean flag = false;
        for (Skill skill : skills) {
            for (Skill elementSkill : groupSkills) {
                if ((skill.getNameSkill().equals(elementSkill.getNameSkill())) &&
                        (skill.getYearSkill().equals(elementSkill.getYearSkill())) &&
                        (skill.getLastUsedSkill().equals(elementSkill.getLastUsedSkill()))) {
                    flag = true;
                } else flag = false;
            }
            if (flag) bySkill.add(skill);
        }
        return bySkill;
    }

}
