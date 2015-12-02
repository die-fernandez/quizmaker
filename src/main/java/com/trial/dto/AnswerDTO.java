package com.trial.dto;

import com.trial.domain.Answer;
import com.trial.domain.Choice;
import com.trial.domain.Question;

/**
 * Created by diego.fernandez on 12/1/15.
 */

public class AnswerDTO {

    private Long questionId;
    private Long choiceId;
    private Long answerId;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    private Long attemptId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Long choiceId) {
        this.choiceId = choiceId;
    }

    public Answer asAnswer(Question question, Choice choice){
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setChoice(choice);
        return answer;
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }
}
