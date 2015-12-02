package com.trial.repository;

import com.trial.TestmakerApplication;
import com.trial.builder.*;
import com.trial.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestmakerApplication.class)
public class AttemptRepositoryTest {

    @Autowired
    AttemptRepository attemptRepository;

    @Autowired
    ExamRepository examRepository;

    AttemptBuilder attemptBuilder;

    AnswerBuilder answerBuilder;

    ExamBuilder examBuilder;

    QuestionBuilder questionBuilder;

    ChoiceBuilder choiceBuilder;


    Exam exam1;
    Attempt attempt1;
    Choice choice1_1;
    Choice choice1_2;
    Choice choice1_3;
    Choice choice2_1;
    Choice choice2_2;
    Choice choice2_3;
    Choice choice2_4;
    Question question1;
    Question question2;

    @Before
    public void setupData(){

        choice1_1 = ChoiceBuilder.aChoice()
                .withDescription("c")
                .withcIndex(1)
                .andCorrect()
                .build();

        choice1_2 =  ChoiceBuilder.aChoice()
                .withDescription("javascript")
                .withcIndex(2)
                .build();

        choice1_3 = ChoiceBuilder.aChoice()
                .withDescription("smalltalk")
                .withcIndex(3)
                .build();

        //question 1
        question1 = QuestionBuilder
                .aQuestion()
                .withDescription("wich one is not an interpreted language?")
                .withChoice(choice1_1)
                .withChoice(choice1_2)
                .withChoice(choice1_3)
                .build();

        choice2_1 = ChoiceBuilder.aChoice()
                .withDescription("JVM")
                .withcIndex(3)
                .andCorrect()
                .build();

        choice2_2 = ChoiceBuilder.aChoice()
                .withDescription("JDK")
                .withcIndex(1)
                .build();

        choice2_3 = ChoiceBuilder.aChoice()
                .withDescription("JRE")
                .withcIndex(2)
                .build();

        choice2_4 = ChoiceBuilder.aChoice()
                .withDescription("None of the above")
                .withcIndex(4)
                .build();

        //question 2
        question2 = QuestionBuilder
                .aQuestion()
                .withDescription("The life cycle of the thread is controlled by ?")
                .withChoice(choice2_1)
                .withChoice(choice2_2)
                .withChoice(choice2_3)
                .withChoice(choice2_4)
                .build();

        //exam1 building

        exam1 = ExamBuilder.anExam()
                .withDescription("my first exam")
                .withQuestion(question1)
                .withQuestion(question2)
                .build();

    }

    @Test
    public void testSaveAttempt(){
        Answer answer1 = AnswerBuilder.anAnswer()
                .withChoice(choice1_1)
                .withQuestion(question1)
                .build();

        Answer answer2 = AnswerBuilder.anAnswer()
                .withChoice(choice2_1)
                .withQuestion(question2)
                .build();

        attempt1 = AttemptBuilder.anAttempt()
                .withAnswer(answer1)
                .withAnswer(answer2)
                .withExam(exam1)
                .andPassed()
                .build();

        attemptRepository.save(attempt1);
    }


}
