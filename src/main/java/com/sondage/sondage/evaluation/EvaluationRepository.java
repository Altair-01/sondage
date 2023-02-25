package com.sondage.sondage.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query("select a from Evaluation a where a.id = ?1")
    public Evaluation findEvaluationById(Long id);

}
