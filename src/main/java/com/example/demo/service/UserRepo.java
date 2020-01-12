package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepo
 */
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findBySalaryGreaterThan(float salary);
    List<User> findBySalaryLessThan(float salary);
    List<User> findByTasksIsEmpty();
    List<User> findByLastLoginBetween(LocalDateTime startDate, LocalDateTime endDate); // 2020-01-01 00:00:00 - 2020-01-01 23:59:59
}