package com.tpp.tpplab3.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.tpp.tpplab3.models.*;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private String url = "jdbc:postgresql://localhost:5432/university_db";
    private String user = "postgres";
    private String password = "admin";

    // СТУДЕНТИ
    public List<Student> findAll() {
        List<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY id";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(new Student(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Student> findByLastNameInsecure(String lastName) {
        List<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE last_name = '" + lastName + "'";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(new Student(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveStudent(String firstName, String lastName, Integer groupId) {
        String sql = "INSERT INTO students (first_name, last_name, group_id) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, groupId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ГРУПИ
    public List<Group> findAllGroups() {
        List<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM groups ORDER BY id";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                groups.add(new Group(rs.getInt("id"), rs.getString("group_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public void saveGroup(String groupName) {
        String sql = "INSERT INTO groups (group_name) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, groupName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> findAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT id, course_name, teacher_name FROM courses ORDER BY id";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(new Course(rs.getInt("id"), rs.getString("course_name"), rs.getString("teacher_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void saveCourse(String courseName) {
        String sql = "INSERT INTO courses (course_name, teacher_name) VALUES (?, 'No Teacher')";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grade> findAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT id, student_id, course_id, grade FROM grades ORDER BY id";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                grades.add(new Grade(rs.getInt("id"), rs.getLong("student_id"), rs.getInt("course_id"),
                        rs.getInt("grade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public void saveGrade(Long studentId, Integer courseId, Integer gradeValue) {
        String sql = "INSERT INTO grades (student_id, course_id, grade) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.setInt(3, gradeValue);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(String tableName, Integer id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}