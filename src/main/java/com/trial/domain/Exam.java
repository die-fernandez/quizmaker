package com.trial.domain;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@Entity
public class Exam {

    public static final Duration DEFAULT_DURATION = Duration.ofMinutes(90);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Duration duration;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
