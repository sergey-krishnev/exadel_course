package com.company.Skills;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SkillFilterImpl implements ISkillFilter {
    private List<Skill> skills;

    public SkillFilterImpl(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public List<Skill> findAll() {
        return null;
    }

    @Override
    public List<Skill> findAll(Comparator<Skill> comparator) {
        return  skills;
    }

    @Override
    public List<Skill> findByType(String type) {
        return skills;
    }

    @Override
    public List<Skill> findByType(String type, Comparator<Skill> comparator) {
        return skills;
    }

    @Override
    public List<Skill> findByStatus(String status) {
        return skills;
    }

    @Override
    public List<Skill> findByStatus(String status, Comparator<Skill> comparator) {
        return skills;
    }

    @Override
    public List<Skill> findByLastCheck(Date last) {
        return skills;
    }

    @Override
    public List<Skill> findByLastCheck(Date last, Comparator<Skill> comparator) {
        return skills;
    }
}
