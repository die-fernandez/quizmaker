package com.trial.repository;

import com.trial.domain.Question;
import com.trial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diego.fernandez on 12/2/15.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
