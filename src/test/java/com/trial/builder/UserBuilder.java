package com.trial.builder;

import com.trial.domain.User;

/**
 * Created by diego.fernandez on 12/2/15.
 */
public class UserBuilder {

    private static final String DEFAULT_NAME = "user";
    private static final String DEFAULT_EMAIL = "user@mail.com";
    private static final String DEFAULT_PASSWORD = "password";
    private Long id;

    private String name = DEFAULT_NAME;

    private String email = DEFAULT_EMAIL;

    private String password = DEFAULT_PASSWORD;

    private UserBuilder() {
    }

    public static UserBuilder aUser(){
        return new UserBuilder();
    }

    public UserBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public UserBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public User build(){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return user;
    }

}
