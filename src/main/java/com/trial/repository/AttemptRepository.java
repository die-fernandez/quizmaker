package com.trial.repository;

import com.trial.domain.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public interface AttemptRepository extends JpaRepository<Attempt,Long> {
    Attempt findOneByUserId(Long id);
}
