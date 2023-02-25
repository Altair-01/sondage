package com.sondage.sondage.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    StatisticsRepository statisticsRepository;

    public List<Statistics> getStatics() {
        return statisticsRepository.findAll();
    }

    @Transactional
    public Statistics createStats(Statistics stats){
        return statisticsRepository.save(stats);
    }

    @Transactional
    public Statistics updateStats(Statistics stats){
        return statisticsRepository.save(stats);
    }

    public Statistics getStatsById(Long id){
        return statisticsRepository.findStatisticsById(id);
    }

    public void deleteStats(Long id){
        boolean existe = statisticsRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Cette stat avec cet id: "+id+" ne peut pas être supprimer");
        }
        statisticsRepository.deleteById(id);
    }
}
