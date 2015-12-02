package com.trial.service.impl;

import com.trial.domain.Answer;
import com.trial.domain.Attempt;
import com.trial.domain.Choice;
import com.trial.domain.Question;
import com.trial.dto.AnswerDTO;
import com.trial.helper.AttemptHelper;
import com.trial.repository.AnswerRepository;
import com.trial.repository.AttemptRepository;
import com.trial.repository.QuestionRepository;
import com.trial.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@Transactional

public class AttemptServiceImpl implements AttemptService{

    @Autowired
    AttemptRepository attemptRepository;
    @Autowired
    AnswerRepository answerRepository;

    /**
     * submits and save an answer for the current attemt
     * the answer could be amended and in that case the choice will be changed
     * @param answerdto
     * @return Answer
     */
    @Override
    public Attempt submitAnswer(AnswerDTO answerdto) {
        Answer answer = null;
        Attempt attempt = attemptRepository.findOne(answerdto.getAttemptId());

        Question question =
                AttemptHelper.getQuestionFromExamById(attempt.getExam(),answerdto.getQuestionId());
        Choice choice =
                AttemptHelper.getChoiceFromQuestionById(question, answerdto.getChoiceId());

        if (answerdto.getAnswerId() != null)
        {
            //the question was already answered
            answer = answerRepository.findOne(answerdto.getAnswerId());
            answer.setChoice(choice);
            answer.setQuestion(question);
            answerRepository.save(answer);

        }else{
            answer = answerdto.asAnswer(question, choice);
        }

        //if the question wasn't already answered
        if(! attempt.getAnswers().contains(answer)) {
            attempt.getAnswers().add(answer);
        }

        attemptRepository.save(attempt);

        return attempt;
    }

    /**
     * Check the submitted answers as well as the remaining time
     *
     * @param attemptId
     * @return Attempt
     */
    @Override
    public Attempt submitAttempt(Long attemptId) {
        //first we check the remaining time
        Attempt attempt = attemptRepository.findOne(attemptId);
        Duration duration = attempt.getExam().getDuration();
        LocalDateTime startTime = attempt.getStartTime();
        if (LocalDateTime.now().isBefore(startTime.plus(duration))){
            Boolean passed = Boolean.TRUE;
            //we are on time
            for (Question question: attempt.getExam().getQuestions()){
                passed =
                    attempt.getAnswers()
                    .stream()
                    .filter(answer -> {
                        //checking if both the question and choice are correct
                        return answer.getChoice().equals(question.getRightChoice()) && answer.getQuestion().equals(question);
                    })
                    .findFirst()
                    .isPresent();

                if (!passed){
                    break;
                }
            }

            attempt.setPassed(passed);

        }else{
            attempt.setPassed(Boolean.FALSE);
            //time is up
        }

        attemptRepository.save(attempt);
        return attempt;
    }

    public AttemptRepository getAttemptRepository() {
        return attemptRepository;
    }

    public void setAttemptRepository(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    public AnswerRepository getAnswerRepository() {
        return answerRepository;
    }

    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
}
