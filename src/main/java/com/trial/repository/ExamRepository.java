package com.trial.repository;

import com.trial.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diego.fernandez on 12/1/15.
 */
public interface ExamRepository extends JpaRepository<Exam,Long> {
}
