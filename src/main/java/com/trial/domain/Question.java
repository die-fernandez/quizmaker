package com.trial.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Choice> choices;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public Choice getRightChoice(){
        return choices
                .stream()
                .filter(choice -> choice.getCorrect())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No right choice set for the answer"));
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
