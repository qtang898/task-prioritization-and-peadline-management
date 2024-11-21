package com.CIS111B.taskmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Homework extends Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String subject;
    private String notes;
    private String pages;
    private String teacherNotes;
    private String assignmentType;
    private String dueDate;


    public Homework() {}


    public Homework(String taskTitle, int level, String type, int userId, String status,
                    String subject, String notes, String pages, String teacherNotes, String assignmentType, String dueDate) {
        super(taskTitle, level, type, userId, status);
        this.subject = subject;
        this.notes = notes;
        this.pages = pages;
        this.teacherNotes = teacherNotes;
        this.assignmentType = assignmentType;
        this.dueDate = dueDate;
    }






    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getTeacherNotes() {
        return teacherNotes;
    }

    public void setTeacherNotes(String teacherNotes) {
        this.teacherNotes = teacherNotes;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

