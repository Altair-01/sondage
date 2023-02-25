package com.sondage.sondage.ask;

import com.sondage.sondage.survey.Survey;
import com.sondage.sondage.survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AskService {
    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    AskRepository askRepository;

    public List<Ask> findAllAsk(){
        return askRepository.findAll();
    };
    public Ask getAskById(Long id){
        return askRepository.findAskById(id);
    }
    public void deleteAsk(Long id){
        boolean existe = askRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Cette question avec cet id: "+id+" ne peut pas être supprimer car n'existe pas");
        }
         askRepository.deleteById(id);
    }

    public Ask addAsk(Ask ask, Long surveyId){
        Survey survey = surveyRepository.findSurveyById(surveyId);
        if (survey == null) {
            throw new IllegalArgumentException("Survey not found");
        }

        ask.setSurvey(survey);
        return askRepository.save(ask);
    }

}
