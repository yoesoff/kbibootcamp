package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee
 */
@Entity
@Table(name="Employee") 
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String desc;

    // private List<Task> tasks;

    public Employee() {
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

    // public List<Task> getTasks() {
    //     return tasks;
    // }

    // public void setTasks(List<Task> tasks) {
    //     this.tasks = tasks;
    // }

    @Override
    public String toString() {
        return "Employee [desc=" + desc + ", id=" + id + "]";
    }

}