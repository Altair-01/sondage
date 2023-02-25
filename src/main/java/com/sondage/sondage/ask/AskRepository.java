package com.sondage.sondage.ask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
    @Query("select a from Ask a where a.id = ?1")
    public Ask findAskById(Long id);

}
