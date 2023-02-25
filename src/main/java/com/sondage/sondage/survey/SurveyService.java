package com.sondage.sondage.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;
    public List<Survey> getSurveys(){
        return surveyRepository.findAll();
    }


    @Transactional
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Transactional
    public Survey updateSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }
    public Survey getSurveyById(Long id){
        return surveyRepository.findSurveyById(id);
    }
    public void deleteSurvey(Long id){
        boolean existe = surveyRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Ce sondage avec cet id: "+id+" ne peut pas être supprimer");
        }
        surveyRepository.deleteById(id);
    }
}
