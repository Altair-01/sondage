package com.sondage.sondage.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    @Query("select a from Statistics a where a.id = ?1")
    public Statistics findStatisticsById(Long id);

}