package com.trial.builder;

import com.trial.domain.Choice;
import com.trial.domain.Exam;
import com.trial.domain.Question;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.fernandez on 12/1/15.
 */

public class ExamBuilder {

    public static final String DEFAULT_DESCRIPTION =  "default description";
    private static final Long DEFAULT_ID = null;

    private String description =  DEFAULT_DESCRIPTION;
    private List<Question> questions = new ArrayList<>();
    private Duration duration = Exam.DEFAULT_DURATION;

    private Long id = DEFAULT_ID;

    private ExamBuilder() {
    }

    public static ExamBuilder anExam(){
        return new ExamBuilder();
    }

    public ExamBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public ExamBuilder withQuestion(Question question){
        this.questions.add(question);
        return this;
    }

    public ExamBuilder withDuration(Duration duration){
        this.duration = duration;
        return this;
    }

    public ExamBuilder andNullId(){
        this.id = null;
        return this;
    }

    public Exam build(){
        Exam exam = new Exam();
        exam.setDescription(description);
        exam.setQuestions(questions);
        exam.setDuration(duration);
        exam.setId(id);
        return exam;
    }

    public ExamBuilder withId(Long id) {
        this.id = id;
        return this;
    }
}
