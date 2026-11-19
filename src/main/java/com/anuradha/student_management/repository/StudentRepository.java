package com.anuradha.student_management.repository;

import com.anuradha.student_management.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add Student
    public int save(Student student) {
        String rollNumber = "STU" + System.currentTimeMillis();

        String sql = "INSERT INTO students (roll_number, full_name, email, course) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
            sql,
            rollNumber,
            student.getName(),
            student.getEmail(),
            student.getCourse()
        );
    }

    // Show All Students
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Student(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("course")
            )
        );
    }

    // Find Student By ID
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
            new Student(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getString("course")
            ),
            id
        );
    }

    // Update Student
    public int update(Student student) {
        String sql = "UPDATE students SET full_name = ?, email = ?, course = ? WHERE id = ?";

        return jdbcTemplate.update(
            sql,
            student.getName(),
            student.getEmail(),
            student.getCourse(),
            student.getId()
        );
    }

    // Delete Student
    public int delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Count Total Students
    public int countStudents() {
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}