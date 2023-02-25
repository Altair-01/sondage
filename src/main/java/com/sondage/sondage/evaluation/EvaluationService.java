package com.sondage.sondage.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluation() {
        return evaluationRepository.findAll();
    }

    @Transactional
    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

   /*
   * @Transactional
    public Evaluation updateEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }
   * */

    @Transactional
    public void deleteEvaluationById(Long id) {
        boolean existe = evaluationRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Cette evaluation avec cet id: "+id+" ne peut pas être supprimer car non existant");
        }
        evaluationRepository.deleteById(id);
    }

    public Evaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id).orElse(null);
    }
}
