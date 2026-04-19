package com.tpp.tpplab3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Автоматично створює геттери, сеттери, toString, equals та hashCode
@NoArgsConstructor // Створює порожній конструктор
@AllArgsConstructor // Створює конструктор з усіма полями 
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer groupId;
}