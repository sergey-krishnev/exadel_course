package com.company.Skills;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DisplayImpl implements IDisplay {
    @Override
    public void display(List<Skill> skills) {
        SkillTreeNode skillTreeNode = new SkillTreeNode(skills);

        for (SkillTreeNode mainChildren : skillTreeNode.getChildren()) {
            SkillTreeNode prev = null;
            String tabs = "";
            SkillTreeNode node = mainChildren;
            while (node.getData() == null) {
                tabs = tabs + "    ";
                System.out.println(tabs + node.getName());
                prev = node;
                node = node.getChildren().get(0);
            }
            tabs = tabs + "    ";
            if (prev.getChildren().size() != 0) {
                for (SkillTreeNode children : prev.getChildren()) {
                    System.out.println(tabs + children.getData().getNameSkill());
                }
            }else {
                    System.out.println(" ");
                }
            }
        }


}
