package com.company.Skills;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SkillsFileReader {
    String nameFile;
    Integer sizeFile;
    List<String> nameSkillList = new ArrayList<>();
    List<String> skillTypeList = new ArrayList<>();
    List<String> skillStatusList = new ArrayList<>();

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public Integer getSizeFile() {
        return sizeFile;
    }

    public void setSizeFile(Integer sizeFile) {
        this.sizeFile = sizeFile;
    }

    public List<String> getNameSkillList() {
        return nameSkillList;
    }

    public void setNameSkillList(List<String> nameSkillList) {
        this.nameSkillList = nameSkillList;
    }

    public List<String> getSkillTypeList() {
        return skillTypeList;
    }

    public void setSkillTypeList(List<String> skillTypeList) {
        this.skillTypeList = skillTypeList;
    }

    public List<String> getSkillStatusList() {
        return skillStatusList;
    }

    public void setSkillStatusList(List<String> skillStatusList) {
        this.skillStatusList = skillStatusList;
    }

    public SkillsFileReader(String nameFile) throws IOException {
        List<String> dataSkill = Files.readAllLines(Paths.get(nameFile), StandardCharsets.UTF_8);
        for (Integer i = 0; i < dataSkill.size(); i++) {
            String[] splitLineSkill = dataSkill.get(i).split(" ; ");
            this.nameSkillList.add(splitLineSkill[0]);
            this.skillTypeList.add(splitLineSkill[1]);
            this.skillStatusList.add(splitLineSkill[2]);
        }
        this.nameFile = nameFile;
        this.sizeFile = dataSkill.size();
    }
}
