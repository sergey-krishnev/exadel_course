package com.company.Skills;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SkillTreeNode {

    private String name;
    private Skill data;
    private List<SkillTreeNode> children = new ArrayList<>();

    public SkillTreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillTreeNode> getChildren() {
        return children;
    }

    public List<SkillTreeNode> getChildren(int indent) {
        List<SkillTreeNode> indentChildren = new ArrayList<>();
        for ( SkillTreeNode child : children) {
            child.name += colIndent(indent);
            indentChildren.add(child);
        }
        return indentChildren;
    }

    public void setChildren(List<SkillTreeNode> children) {
        this.children = children;
    }

    public Skill getData() {
       return data;
    }

    public void setData(Skill data) {
        this.data = data;
    }

    public SkillTreeNode(List<Skill> skills) {
        SkillTreeNode root = new SkillTreeNode("");
        for (Skill skill: skills) {
            SkillTreeNode node = root;

            String[] strings = skill.getNameSkill().split(" / ");
            for (String line : strings) {
                SkillTreeNode child = node.getChildren().stream()
                        .filter(ch -> Objects.equals(line, ch.getName()))
                        .findFirst()
                        .orElse(null);
                if (child == null) {
                    child = new SkillTreeNode(line);
                    node.getChildren().add(child);
                    node.getChildren().sort(Comparator.comparing(SkillTreeNode::getName));
                }
                node = child;
            }
            node.setData(skill);
        }
        this.name = root.getName();
        this.children = root.getChildren();
    }
    /*public void display() {
        System.out.printf("Name: %s \t Children: %s \n",getName(),getChildren());
    }*/
    public void displayChildren(int j) {
        for (int i = 0 ; i < getChildren(j).size() ; i++) {
            System.out.print(getChildren(j).get(i).name + " ");
            if (getChildren(j).get(i).data != null) {
                System.out.println(getChildren(j).get(i).data.displayToListString());
            } else
                System.out.println(" ");
        }
    }
    public static String colIndent(int col) {
        String tab = "";
        for (int i = 0 ; i < col ; i++) {
            tab += "\t ";
        }
        return tab;
    }
    @Override
    public String toString() {
        return "{" + name + '\n' + children + '}';
    }
}
