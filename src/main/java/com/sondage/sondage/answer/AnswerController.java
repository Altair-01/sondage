package com.sondage.sondage.answer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> getAllAnswers() {
        return  answerService.getAnswers();
    }

    // Get a specific response by ID
    @GetMapping("/id/{answer}")
    @ResponseStatus(HttpStatus.OK)
    public Answer findAnswerById(@PathVariable Long answerId){
        return answerService.getAnswerById(answerId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Answer addAnswer(@RequestBody Answer newAnswer) {
        return answerService.saveAnswer(newAnswer);

    }
    @DeleteMapping("/delete/{answerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnswer(@PathVariable Long answerId){
         answerService.deleteAnswer(answerId);
    }

}
