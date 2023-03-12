package com.sondage.sondage.ask;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ask")

public class AskController {

    private final AskService askService;

    public AskController(AskService askService) {
        this.askService = askService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Ask> findAll() {
        return  askService.findAllAsk();
    }

    // Get a specific response by ID
    @GetMapping("/id/{askId}")
    @ResponseStatus(HttpStatus.OK)
    public Ask findAskById(@PathVariable Long askId){
        return askService.getAskById(askId);
    }

    //POST new answers for site
    @PostMapping("/{surveyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ask createSurveyAsk(@RequestBody Ask ask, @PathVariable Long surveyId) {
        return askService.addAsk(ask,surveyId);
    }
    /*POST new answers for site
    @PostMapping("{agentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAgentAnswer(@RequestBody Answer answer, @PathVariable Long agentId) {
        return askService.addAnswer(answer, agentId);
    }*/
    @DeleteMapping("/delete/{askId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAsk(@PathVariable Long askId){
        askService.deleteAsk(askId);
    }

}
