package com.trial.repository;

import com.trial.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
