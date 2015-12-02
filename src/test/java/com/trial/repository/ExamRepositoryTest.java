package com.trial.repository;

import com.trial.TestmakerApplication;
import com.trial.builder.ChoiceBuilder;
import com.trial.builder.ExamBuilder;
import com.trial.builder.QuestionBuilder;
import com.trial.domain.Choice;
import com.trial.domain.Exam;
import com.trial.domain.Question;
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
public class ExamRepositoryTest {

    @Autowired
    ExamRepository examRepository;

    ExamBuilder examBuilder;

    QuestionBuilder questionBuilder;

    ChoiceBuilder choiceBuilder;

    Exam exam1;

    @Before
    public void setupData(){

        //exam 1 dependencies

        Choice choice1_1 = ChoiceBuilder.aChoice()
                .withDescription("c")
                .withcIndex(1)
                .andCorrect()
                .build();

        Choice choice1_2 =  ChoiceBuilder.aChoice()
                .withDescription("javascript")
                .withcIndex(2)
                .build();

        Choice choice1_3 = ChoiceBuilder.aChoice()
                .withDescription("smalltalk")
                .withcIndex(3)
                .build();

        //question 1
        Question question1 = QuestionBuilder
                .aQuestion()
                .withDescription("wich one is not an interpreted language?")
                .withChoice(choice1_1)
                .withChoice(choice1_2)
                .withChoice(choice1_3)
                .build();

        Choice choice2_1 = ChoiceBuilder.aChoice()
                .withDescription("JVM")
                .withcIndex(3)
                .andCorrect()
                .build();

        Choice choice2_2 = ChoiceBuilder.aChoice()
                .withDescription("JDK")
                .withcIndex(1)
                .build();

        Choice choice2_3 = ChoiceBuilder.aChoice()
                .withDescription("JRE")
                .withcIndex(2)
                .build();

        Choice choice2_4 = ChoiceBuilder.aChoice()
                .withDescription("None of the above")
                .withcIndex(4)
                .build();

        //question 2
        Question question2 = QuestionBuilder
                .aQuestion()
                .withDescription("The life cycle of the thread is controlled by ?")
                .withChoice(choice2_1)
                .withChoice(choice2_2)
                .withChoice(choice2_3)
                .withChoice(choice2_4)
                .build();

        Choice choice3_1 = ChoiceBuilder.aChoice()
                .withDescription("True")
                .withcIndex(2)
                .build();

        Choice choice3_2 = ChoiceBuilder.aChoice()
                .withDescription("False")
                .withcIndex(1)
                .build();

        //question 3
        Question question3 = QuestionBuilder
                .aQuestion()
                .withDescription("Thread class constructor allocates a new thread object?")
                .withChoice(choice3_1)
                .withChoice(choice3_2)
                .build();


        //exam1 building

        exam1 = ExamBuilder.anExam()
                .withDescription("my first exam")
                .withQuestion(question1)
                .withQuestion(question2)
                .withQuestion(question3)
                .build();

    }

    @Test
    public void testSaveExam(){

        examRepository.save(exam1);

    }

}
