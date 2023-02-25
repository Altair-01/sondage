package com.sondage.sondage.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<List<Statistics>> getAllStatistics() {
        List<Statistics> statisticsList = statisticsService.getStatics();
        return new ResponseEntity<>(statisticsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistics> getStatisticsById(@PathVariable Long id) {
        Statistics statistics = statisticsService.getStatsById(id);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Statistics> createStatistics(@RequestBody Statistics statistics) {
        Statistics createdStatistics = statisticsService.createStats(statistics);
        return new ResponseEntity<>(createdStatistics, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistics(@PathVariable Long id) {
        statisticsService.deleteStats(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
