package com.sondage.sondage.survey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Survey> getAllSurveys() {
        return  surveyService.getSurveys();
    }

    // Get a specific response by ID
    @GetMapping("/id/{surveyId}")
    @ResponseStatus(HttpStatus.OK)
    public Survey findSurveyById(@PathVariable Long surveyId){
        return surveyService.getSurveyById(surveyId);
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey( @RequestBody Survey survey)
    {
        Survey createdSurvey = surveyService.createSurvey(survey);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(
            @PathVariable("id") Long id,
            @RequestBody Survey survey
    ) {
        Survey existingSurvey = surveyService.getSurveyById(id);
        if (existingSurvey == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        survey.setId(id);
        Survey updatedSurvey = surveyService.updateSurvey(survey);
        return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{surveyId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSurvey(@PathVariable Long surveyId){
        surveyService.deleteSurvey(surveyId);
    }

}
