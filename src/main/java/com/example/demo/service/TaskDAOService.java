package com.example.demo.service;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.demo.model.Task;

/**
 * TaskDAOService
 */
@Repository
public class TaskDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Integer insert(Task task) {
        entityManager.persist(task);
        return task.getId();
    }
}