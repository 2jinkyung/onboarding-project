package com.example.demo.question.Repository;

import com.example.demo.question.domain.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemaQuestionRepository extends JpaRepository<QuestionType, Long> {

}
