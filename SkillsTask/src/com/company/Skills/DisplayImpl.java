package com.company.Skills;

import java.util.List;

public class DisplayImpl implements IDisplay {
    @Override
    public void display(List<Skill> skills) {

        SkillTreeNode skillTreeNode = new SkillTreeNode(skills);

    }
}
