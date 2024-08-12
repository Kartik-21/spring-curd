package com.kartik.curd.entity.school;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

/*
 *
 * this is child of Teacher entity
 * so, this class manage the association
 *
 * */

@Entity
public class Supervisor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "supervisor")
    private Teacher teacher;


    public Teacher getTeacher() {
        return teacher;
    }


    public Supervisor(String name) {
        this.name = name;
    }

    public Supervisor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
