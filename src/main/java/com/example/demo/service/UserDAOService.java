package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.demo.model.User;

import org.springframework.stereotype.Repository;

/**
 * UserDAOService
 */
@Repository
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Integer insert(User user) {
        entityManager.persist(user);
        return user.getId();
    }
}