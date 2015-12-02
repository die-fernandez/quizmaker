package com.trial.domain;

import javax.persistence.*;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Choice choice;

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public void setId(Long id) {
        this.id = id;
    }
}