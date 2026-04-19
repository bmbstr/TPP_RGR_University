package com.tpp.tpplab3.repository;

import com.tpp.tpplab3.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("role"));

    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(sql, userRowMapper, username)
                .stream()
                .findFirst();
    }

    // ДОДАЙ ЦЕЙ МЕТОД ДЛЯ РЕЄСТРАЦІЇ
    public void saveUser(String username, String password, String role) {
        // Ми вставляємо тільки username, password та role.
        // ID зазвичай генерується базою автоматично (SERIAL), а enabled ставимо true.
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, username, password, role);
    }
}