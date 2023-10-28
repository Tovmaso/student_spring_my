package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discipline {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    private String discipline;
    private int status;

    public Discipline() {
    }

    public Discipline(String discipline, int status) {
        this.discipline = discipline;
        this.status = status;
    }

    public Discipline(Long id, String discipline, int status) {
        this.id = id;
        this.discipline = discipline;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
