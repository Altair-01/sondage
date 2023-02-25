package com.sondage.sondage.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAnswers(){
        return answerRepository.findAll();
    }


    public Answer getAnswerById(Long id){
        return answerRepository.findAnswerById(id);
    }
    public void deleteAnswer(Long id){
        boolean existe = answerRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Cette reponse avec cet id: "+id+" ne peut pas être supprimer car non existant");
        }
        answerRepository.deleteById(id);
    }
}
