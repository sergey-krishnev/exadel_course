package com.company.Skills;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DisplayImpl implements IDisplay {
    @Override
    public void display(List<Skill> skills) {
          SkillTreeNode skillTreeNode = new SkillTreeNode(skills);
//        SkillTreeNode prev = null;
//        for (SkillTreeNode mainChildren : skillTreeNode.getChildren()) {
//            String tabs = "";
//            SkillTreeNode node = mainChildren;
//            while (node.getData() == null) {
//                tabs = tabs + "    ";
//                System.out.println(tabs + node.getName());
//                prev = node;
//                node = node.getChildren().get(0);
//            }
//            tabs = tabs + "    ";
//                for (SkillTreeNode children : prev.getChildren()) {
//                    System.out.println(tabs + children.getData().getNameSkill());
//                }
//            }
        for (SkillTreeNode mainChildren : skillTreeNode.getChildren()) {
            if (mainChildren.getData() == null) {
                System.out.println(mainChildren.getName());
                for (SkillTreeNode subChildren : mainChildren.getChildren()) {
                    if (subChildren.getData() == null) {
                        System.out.println("    " + subChildren.getName());
                        for (SkillTreeNode lastChildren : subChildren.getChildren()) {
                            System.out.println("        " + lastChildren.getName() +
                                    lastChildren.getData().displayToListString());
                        }
                    }else {
                            System.out.println("    " + subChildren.getName() +
                                    subChildren.getData().displayToListString());
                        }
                    }
            } else {
                System.out.println(mainChildren.getName() + mainChildren.getData().displayToListString());
            }
        }
    }

}
