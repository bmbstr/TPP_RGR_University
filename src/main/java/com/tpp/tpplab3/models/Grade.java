package com.tpp.tpplab3.models;

public class Grade {
    private Integer id;
    private Long studentId;
    private Integer courseId;
    private Integer grade;

    public Grade(Integer id, Long studentId, Integer courseId, Integer grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Integer getGrade() {
        return grade;
    }
}