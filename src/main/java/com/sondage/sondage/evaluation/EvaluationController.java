package com.sondage.sondage.evaluation;

import com.sondage.sondage.agent.Agent;
import com.sondage.sondage.site.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/all")
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationService.getAllEvaluation();
        return new ResponseEntity<>(evaluations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(
            @RequestBody Evaluation evaluation,
            @RequestParam(name = "site_id", required = false) Long siteId,
            @RequestParam(name = "agent_id", required = false) Long agentId
    ) {
        Site site = new Site();
        site.setId(siteId);

        Agent agent = new Agent();
        agent.setId(agentId);

        evaluation.setSite(site);
        evaluation.setAgent(agent);
        evaluation.setDate(LocalDate.now());

        Evaluation createdEvaluation = evaluationService.createEvaluation(evaluation);
        return new ResponseEntity<>(createdEvaluation, HttpStatus.CREATED);
    }

    /*
    * @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(
            @PathVariable("id") Long id,
            @RequestBody Evaluation evaluation
    ) {
        Evaluation existingEvaluation = evaluationService.getEvaluationById(id);
        if (existingEvaluation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        evaluation.setId(id);
        Evaluation updatedEvaluation = evaluationService.updateEvaluation(evaluation);
        return new ResponseEntity<>(updatedEvaluation, HttpStatus.OK);
    }
    * */


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable("id") Long id) {
        Evaluation existingEvaluation = evaluationService.getEvaluationById(id);
        if (existingEvaluation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        evaluationService.deleteEvaluationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable("id") Long id) {
        Evaluation evaluation = evaluationService.getEvaluationById(id);
        if (evaluation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(evaluation, HttpStatus.OK);
    }
}
