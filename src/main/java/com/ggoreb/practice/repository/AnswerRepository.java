package com.ggoreb.practice.repository;

import com.ggoreb.practice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ggoreb.practice.model.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
