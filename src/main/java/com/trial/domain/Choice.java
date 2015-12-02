package com.trial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by diego.fernandez on 12/1/15.
 */

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Integer cIndex;

    @ManyToOne
    private Question question;

    @JsonIgnore
    private Boolean correct;


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getcIndex() {
        return cIndex;
    }

    public void setcIndex(Integer cIndex) {
        this.cIndex = cIndex;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
