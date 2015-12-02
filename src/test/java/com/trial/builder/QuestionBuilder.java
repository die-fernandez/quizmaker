package com.trial.builder;

import com.trial.domain.Choice;
import com.trial.domain.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public class QuestionBuilder {

    public static final String DEFAULT_DESCRIPTION =  "default description";
    private static final Long DEFAULT_ID = null;

    private String description = DEFAULT_DESCRIPTION;
    private List<Choice> choices = new ArrayList<>();

    private Long id = DEFAULT_ID;

    private QuestionBuilder() {

    }

    public static QuestionBuilder aQuestion() {
        return new QuestionBuilder();
    }

    public QuestionBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public QuestionBuilder withChoice(Choice choice){
        this.choices.add(choice);
        return this;
    }

    public QuestionBuilder andNullId(){
        this.id = null;
        return this;
    }

    public Question build(){
        Question question = new Question();
        question.setDescription(description);
        question.setChoices(choices);
        question.setId(id);
        return question;
    }

    public QuestionBuilder withId(long id) {
        this.id = id;
        return this;
    }
}
