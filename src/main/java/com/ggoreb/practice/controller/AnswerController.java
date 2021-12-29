package com.ggoreb.practice.controller;

import com.ggoreb.practice.model.Answer;
import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.AnswerRepository;
import com.ggoreb.practice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/answer/create")
    public String answerQuestion(@RequestParam("qId") Long qId, Answer answer, HttpSession session){
        String url="redirect:/question/detail?id="+qId;
        System.out.println(qId+":"+answer);
        Question question = questionRepository.findById(qId).get();
        answer.setQuestion(question);
        User user=(User) session.getAttribute("user");
        answer.setUser(user);
        answer.setCreateDate(new Date());
        answerRepository.save(answer);
        return url;
    }
}
