package com.sondage.sondage.answer;

import com.sondage.sondage.agent.Agent;
import com.sondage.sondage.evaluation.Evaluation;
import com.sondage.sondage.site.Site;
import com.sondage.sondage.survey.Survey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

@Entity
@Table(name = "_answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;



    @ManyToOne(optional = true)
    @JoinColumn(name = "agent_id", nullable = true)
    private Agent agent;

    @ManyToOne(optional = true)
    @JoinColumn(name = "site_id", nullable = true)
    private Site site;

   @ManyToOne
   @JoinColumn(name = "which_survey_id")
   private Survey survey;

}