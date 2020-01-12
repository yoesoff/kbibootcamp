package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Task
 */
@Entity
@Table(name="Task") 
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String desc;
    private LocalDateTime targetDate;
    private boolean isDone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    // private List<Employee> employees;

    public Task() {
    }

    public Task(String desc, LocalDateTime targetDate, boolean isDone, User user) {
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
        this.user = user;
    }

	public Integer getId() {
		return id;
	}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    // public List<Employee> getEmployees() {
    //     return employees;
    // }

    // public void setEmployees(List<Employee> employees) {
    //     this.employees = employees;
    // }

    @Override
    public String toString() {
        return "Task [desc=" + desc + ", id=" + id + ", isDone=" + isDone + ", targetDate="
                + targetDate + "]";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}