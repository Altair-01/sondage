package com.sondage.sondage.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("select a from Answer a where a.id = ?1")
    public Answer findAnswerById(Long id);

}
