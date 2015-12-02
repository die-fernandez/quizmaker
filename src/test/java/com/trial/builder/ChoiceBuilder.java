package com.trial.builder;

import com.trial.domain.Choice;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public class ChoiceBuilder {

    public static final String DEFAULT_DESCRIPTION =  "default description";

    public static final Integer DEFAULT_INDEX =  1;
    public static final Long DEFAULT_ID =  null;


    private String description = DEFAULT_DESCRIPTION;

    private Integer cIndex = DEFAULT_INDEX;

    private Boolean correct = false;

    private Long id = DEFAULT_ID;

    private ChoiceBuilder() {
    }

    public static ChoiceBuilder aChoice(){
        return new ChoiceBuilder();
    }

    public ChoiceBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public ChoiceBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ChoiceBuilder withcIndex(Integer index){
        this.cIndex = index;
        return this;
    }

    public ChoiceBuilder andCorrect(){
        this.correct = true;
        return this;
    }

    public ChoiceBuilder andNullId(){
        this.id = null;
        return this;
    }

    public ChoiceBuilder andId(Long id){
        this.id = id;
        return this;
    }

    public Choice build(){
        Choice choice = new Choice();
        choice.setCorrect(correct);
        choice.setDescription(description);
        choice.setcIndex(cIndex);
        choice.setId(id);
        return choice;

    }


}
