package com.trial.builder;

import com.trial.domain.Answer;
import com.trial.domain.Choice;
import com.trial.domain.Question;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public class AnswerBuilder {

    private static final Long DEFAULT_ID = null;
    private Question question;

    private Choice choice;
    private Long id = DEFAULT_ID;

    private AnswerBuilder() {
    }

    public static AnswerBuilder anAnswer() {
        return new AnswerBuilder();
    }

    public AnswerBuilder withQuestion(Question question){
        this.question = question;
        return this;
    }

    public AnswerBuilder withChoice(Choice choice){
        this.choice = choice;
        return this;
    }

    public AnswerBuilder andNullId(){
        this.id = null;
        return this;
    }

    public Answer build(){
        Answer answer = new Answer();
        answer.setChoice(choice);
        answer.setQuestion(question);
        answer.setId(id);
        return answer;
    }


    public AnswerBuilder withId(Long  lid) {
        this.id = id;
        return this;
    }
}
