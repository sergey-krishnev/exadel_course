package com.company.Skills;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface ISkillFilter {

    List<Skill> findAll();

    List<Skill> findAll(Comparator<Skill> comparator);

    List<Skill> findByType(String type);

    List<Skill> findByType(String type, Comparator<Skill> comparator);

    List<Skill> findByStatus(String status);

    List<Skill> findByStatus(String status, Comparator<Skill> comparator);

    List<Skill> findByLastCheck(Date last);

    List<Skill> findByLastCheck(Date last, Comparator<Skill> comparator);

}
