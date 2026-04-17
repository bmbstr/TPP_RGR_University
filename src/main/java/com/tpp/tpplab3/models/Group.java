package com.tpp.tpplab3.models;

public class Group {
    private Integer id;
    private String groupName;

    // Конструктор
    public Group(Integer id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    // Геттери
    public Integer getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    // Сеттери
    public void setId(Integer id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}