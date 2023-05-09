package com.projects.exam_management.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionalAnswerRepo extends JpaRepository<OptionalAnswer,Integer> {
}
