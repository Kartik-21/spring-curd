package com.kartik.curd.entity.school;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 *
 * this is parent entity
 * all property define here
 * so helper function added in this class
 *
 * */


@Entity
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teacher", orphanRemoval = true)
    private List<Subject> subjects = new ArrayList<>();

    public List<Subject> getSubjects() {
//       return  (subjects==null)? null : Collections.unmodifiableList(subjects);
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        subjects.forEach(s -> s.setTeacher(this));
        this.subjects = subjects;
    }

    public Teacher() {
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
//        supervisor.setTeacher(this);
        this.supervisor = supervisor;
    }

    /**
     * when we do not set orphanRemoval=true then need helper remove function
     *
     * if we set above property then we don't need helper remove function
     */
    public void removeSupervisor() {
        this.supervisor = null;
    }

}
