package com.trial;

import com.trial.builder.*;
import com.trial.domain.*;
import com.trial.dto.AnswerDTO;
import com.trial.repository.AnswerRepository;
import com.trial.repository.AttemptRepository;
import com.trial.service.AttemptService;
import com.trial.service.impl.AttemptServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class AttemptServiceImplTest {

    AttemptServiceImpl attemptService = new AttemptServiceImpl();

    @Mock
    AttemptRepository attempRepositoryMock;
    @Mock
    AnswerRepository answerRepositoryMock;

    Question question;
    Question question2;
    Answer answer;
    Answer newAnswer;
    Answer wrongAnswer;
    Attempt attempt;
    Attempt emptyAttempt;
    Attempt goodAttempt;
    Attempt wrongAttempt;
    Choice choice;
    Choice newChoice;
    Exam exam;
    private Attempt expiredAttempt;

    @Before
    public void setup(){

        choice = ChoiceBuilder.aChoice()
                .withDescription("oldChoice")
                .andCorrect()
                .withId(1L)
                .build();

        newChoice = ChoiceBuilder.aChoice()
                .withDescription("newChoice")
                .withId(2L)
                .build();

        question = QuestionBuilder.aQuestion()
                .withChoice(choice)
                .withChoice(newChoice)
                .withId(1L)
                .build();

        question2 = QuestionBuilder.aQuestion()
                .withChoice(choice)
                .withChoice(newChoice)
                .withId(1L)
                .build();

        newAnswer = AnswerBuilder.anAnswer()
                .withQuestion(question)
                .withChoice(choice)
                .build();

        answer = AnswerBuilder.anAnswer()
                    .withQuestion(question)
                    .withChoice(choice)
                    .withId(1L)
                    .build();

        wrongAnswer = AnswerBuilder.anAnswer()
                .withQuestion(question)
                .withChoice(newChoice)
                .withId(1L)
                .build();

        exam = ExamBuilder.anExam()
                .withQuestion(question)
                .withId(1L)
                .build();

        attempt = AttemptBuilder.anAttempt()
                .withAnswer(answer)
                .withExam(exam)
                .withId(1L)
                .build();

        emptyAttempt = AttemptBuilder.anAttempt()
                .withExam(exam)
                .withId(1L)
                .build();

        goodAttempt = AttemptBuilder.anAttempt()
                .withAnswer(answer)
                .withExam(exam)
                .withId(1L)
                .build();

        wrongAttempt = AttemptBuilder.anAttempt()
                .withAnswer(wrongAnswer)
                .withExam(exam)
                .withId(1L)
                .build();

        expiredAttempt = AttemptBuilder.anAttempt()
                .withAnswer(answer)
                .withExam(exam)
                .andExpired()
                .withId(1L)
                .build();

    }

    @Test
    public void testReSubmitAnswer(){

        Mockito.when(attempRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(attempt);
        Mockito.when(answerRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(answer);
        attemptService.setAnswerRepository(answerRepositoryMock);
        attemptService.setAttemptRepository(attempRepositoryMock);

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswerId(1L);
        answerDTO.setAttemptId(1L);
        answerDTO.setChoiceId(2L);
        answerDTO.setQuestionId(1L);
        attempt = attemptService.submitAnswer(answerDTO);

        Assert.assertEquals(attempt.getAnswers().size(),1);
        Assert.assertSame(attempt.getAnswers().get(0).getChoice(),newChoice);

    }


    @Test
    public void testSubmitNewAnswer(){

        Mockito.when(attempRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(emptyAttempt);
        Mockito.when(answerRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(null);
        attemptService.setAnswerRepository(answerRepositoryMock);
        attemptService.setAttemptRepository(attempRepositoryMock);

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAttemptId(1L);
        answerDTO.setChoiceId(1L);
        answerDTO.setQuestionId(1L);
        Assert.assertEquals(0,emptyAttempt.getAnswers().size());
        attempt = attemptService.submitAnswer(answerDTO);
        Assert.assertEquals(1,emptyAttempt.getAnswers().size());
        Assert.assertSame(choice,emptyAttempt.getAnswers().get(0).getChoice());
    }

    @Test
    public void testAttemptPassed(){

        Mockito.when(attempRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(attempt);
        attemptService.setAttemptRepository(attempRepositoryMock);
        Attempt attempt = attemptService.submitAttempt(1L);
        Assert.assertTrue(attempt.getPassed());

    }

    @Test
    public void testAttemptFailed(){

        Mockito.when(attempRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(wrongAttempt);
        attemptService.setAttemptRepository(attempRepositoryMock);
        Attempt attempt = attemptService.submitAttempt(1L);
        Assert.assertFalse(attempt.getPassed());

    }

    @Test
    public void testAttemptExpired(){

        Mockito.when(attempRepositoryMock.findOne(Mockito.anyLong()))
                .thenReturn(expiredAttempt);
        attemptService.setAttemptRepository(attempRepositoryMock);
        Attempt attempt = attemptService.submitAttempt(1L);
        Assert.assertFalse(attempt.getPassed());

    }
}
