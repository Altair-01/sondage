package com.sondage.sondage.statistics;

import com.sondage.sondage.survey.Survey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "_statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfEvaluations;

    private Double average;

    @ManyToOne
    private Survey survey;

}
