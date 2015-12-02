package com.trial.service;

import com.trial.domain.Answer;
import com.trial.domain.Attempt;
import com.trial.dto.AnswerDTO;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public interface AttemptService {

    Attempt submitAnswer(AnswerDTO answerdto);

    Attempt submitAttempt(Long attemptId);

}
