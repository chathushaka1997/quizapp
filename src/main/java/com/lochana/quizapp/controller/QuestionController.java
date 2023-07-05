package com.lochana.quizapp.controller;

import com.lochana.quizapp.model.Question;
import com.lochana.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public  ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete/{questionId}")
    public  ResponseEntity<String> deleteQuestion(@PathVariable Integer questionId){

        return questionService.deleteQuestion(questionId);
    }
    @PutMapping("update")
    public  ResponseEntity<String> updateQuestion(@RequestBody Question question){

        return questionService.updateQuestion(question);
    }
}