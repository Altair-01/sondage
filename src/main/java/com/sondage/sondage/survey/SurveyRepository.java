package com.sondage.sondage.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    @Query("select a from Survey a where a.id = ?1")
    public Survey findSurveyById(Long id);

}
