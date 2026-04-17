package com.tpp.tpplab3.controllers;

import com.tpp.tpplab3.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentWebController {

    private final StudentRepository repository;

    public StudentWebController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // СТУДЕНТИ
    @GetMapping("/search")
    public String searchStudents(@RequestParam(required = false) String lastName, Model model) {
        if (lastName != null && !lastName.isEmpty()) {
            model.addAttribute("students", repository.findByLastNameInsecure(lastName));
        } else {
            model.addAttribute("students", repository.findAll());
        }
        return "search";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer groupId) {
        repository.saveStudent(firstName, lastName, groupId);
        return "redirect:/search";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        repository.deleteById("students", id);
        return "redirect:/search";
    }

    // ГРУПИ
    @GetMapping("/groups")
    public String showGroups(Model model) {
        model.addAttribute("groups", repository.findAllGroups());
        return "groups";
    }

    @PostMapping("/groups/add")
    public String addGroup(@RequestParam String groupName) {
        repository.saveGroup(groupName);
        return "redirect:/groups";
    }

    @GetMapping("/groups/delete/{id}")
    public String deleteGroup(@PathVariable Integer id) {
        repository.deleteById("groups", id);
        return "redirect:/groups";
    }

    // КУРСИ
    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("courses", repository.findAllCourses());
        return "courses";
    }

    @PostMapping("/courses/add")
    public String addCourse(@RequestParam String name) {
        repository.saveCourse(name);
        return "redirect:/courses";
    }

    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        repository.deleteById("courses", id);
        return "redirect:/courses";
    }

    // ОЦІНКИ
    @GetMapping("/grades")
    public String showGrades(Model model) {
        model.addAttribute("grades", repository.findAllGrades());
        return "grades";
    }

    @PostMapping("/grades/add")
    public String addGrade(@RequestParam Long studentId, @RequestParam Integer courseId, @RequestParam Integer score) {
        repository.saveGrade(studentId, courseId, score);
        return "redirect:/grades";
    }

    @GetMapping("/grades/delete/{id}")
    public String deleteGrade(@PathVariable Integer id) {
        repository.deleteById("grades", id);
        return "redirect:/grades";
    }
}