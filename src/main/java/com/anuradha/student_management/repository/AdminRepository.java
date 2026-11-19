package com.anuradha.student_management.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAdmin(String username, String password) {

        String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";

        jdbcTemplate.update(sql, username, password);
    }
}
