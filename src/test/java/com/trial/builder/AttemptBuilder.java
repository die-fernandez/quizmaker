package com.trial.builder;

import com.trial.domain.Answer;
import com.trial.domain.Attempt;
import com.trial.domain.Exam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public class AttemptBuilder {

    public static final LocalDateTime DEFAULT_START_TIME = LocalDateTime.now();
    private static final Boolean NOT_PASSED = false;
    private static final Long DEFAULT_ID = null;
    private List<Answer> answers = new ArrayList<>();
    private LocalDateTime startTime = DEFAULT_START_TIME;
    private Boolean passed = NOT_PASSED;

    private Exam exam;
    private Long id = DEFAULT_ID;

    private AttemptBuilder() {
    }

    public static AttemptBuilder anAttempt() {
        return new AttemptBuilder();
    }

    public AttemptBuilder withExam(Exam exam){
        this.exam = exam;
        return this;
    }

    public AttemptBuilder withAnswer(Answer answer){
        this.answers.add(answer);
        return this;
    }

    public AttemptBuilder andPassed(){
        this.passed = Boolean.TRUE;
        return this;
    }


    public Attempt build(){
        Attempt attempt = new Attempt();
        attempt.setAnswers(answers);
        attempt.setPassed(passed);
        attempt.setExam(exam);
        attempt.setStartTime(startTime);
        attempt.setId(id);
        return attempt;
    }


    public AttemptBuilder andExpired() {
        this.startTime = LocalDateTime.MIN;
        return this;
    }

    public AttemptBuilder withId(Long id) {
        this.id = id;
        return this;
    }
}
