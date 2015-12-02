package com.trial.helper;

import com.trial.domain.Choice;
import com.trial.domain.Exam;
import com.trial.domain.Question;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public class AttemptHelper {

    public static Question getQuestionFromExamById(Exam exam, Long id){

        Question question = exam.getQuestions().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
        return question;

    }

    public static Choice getChoiceFromQuestionById(Question question, Long id){

        Choice choice = question.getChoices().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
        return choice;

    }

}
