package com.company.Skills;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SkillTreeNode {

    private String name;
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

    public void setChildren(List<SkillTreeNode> children) {
        this.children = children;
    }

    public SkillTreeNode(List<String> skills) {
        SkillTreeNode root = new SkillTreeNode("");

        for (String skill: skills) {
            SkillTreeNode node = root;

            String[] strings = skill.split(" / ");
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

        }
        this.name = root.getName();
        this.children = root.getChildren();
    }
    /*public void display() {
        System.out.printf("Name: %s \t Children: %s \n",getName(),getChildren());
    }*/

    @Override
    public String toString() {
        return "{" +
                "'" + name + '\'' +
                ", " + children +
                '}';
    }
}
