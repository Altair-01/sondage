package com.sondage.sondage.evaluation;

import com.sondage.sondage.agent.Agent;
import com.sondage.sondage.site.Site;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;


@Table(name = "_evaluations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;


    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;



}