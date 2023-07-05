package com.lochana.quizapp.dao;

import ch.qos.logback.core.boolex.EvaluationException;
import com.lochana.quizapp.model.Question;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery=true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
