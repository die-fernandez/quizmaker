package com.trial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by diego.fernandez on 12/1/15.
 */
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    //roles are not persisted and return a unique role user
    @Transient
    private Set<Role> roles = Stream.of(new Role()).collect(Collectors.toSet());

    public User(){
        super();
        this.getRoles().add(new Role());
    }

    public User(User user) {
        super();
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles(){
       return roles;
    }


    //roles are a static class for simplicity
    static class Role implements GrantedAuthority {

        @Override
        public String getAuthority() {
            return "USER";
        }
    }
}
