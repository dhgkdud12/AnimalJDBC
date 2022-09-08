package com.study.animaljdbc.dto;

public class AnimalUpdateRequestDto {
    private String name;
    private String type;
    private Integer age;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
