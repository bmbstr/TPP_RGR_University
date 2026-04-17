package com.tpp.tpplab3.models;

public class Course {
    private int id;
    private String name;
    private String teacherName;

    // Порожній конструктор
    public Course() {}

    // Конструктор зі всіма полями
    public Course(int id, String name, String teacherName) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
    }

    // Геттери та сеттери (вони потрібні для Thymeleaf)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
}