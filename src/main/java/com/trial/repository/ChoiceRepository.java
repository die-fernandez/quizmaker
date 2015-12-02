package com.trial.repository;

import com.trial.domain.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public interface ChoiceRepository extends JpaRepository<Choice,Long> {
}
