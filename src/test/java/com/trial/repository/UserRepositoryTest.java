package com.trial.repository;

import com.trial.TestmakerApplication;
import com.trial.builder.UserBuilder;
import com.trial.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by diego.fernandez on 12/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestmakerApplication.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Test
    public void testSaveUser(){
        User user = UserBuilder.aUser()
                .withName("beta")
                .withEmail("user@mail.com")
                .withPassword(encoder.encode("password"))
                .build();

        userRepository.save(user);
    }

}
