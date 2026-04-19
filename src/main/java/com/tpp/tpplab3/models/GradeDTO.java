package com.tpp.tpplab3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {
    private Integer id;
    private String studentFullName; // Сюди запишемо Прізвище Ім'я
    private String courseName; // Сюди назву курсу
    private Integer grade;
}