package com.sondage.sondage.answer;

import com.sondage.sondage.agent.Agent;
import com.sondage.sondage.evaluation.Evaluation;
import com.sondage.sondage.site.Site;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ResponseType type;

    public enum ResponseType {
        AGENT, SITE
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "agent_id", nullable = true)
    private Agent agent;

    @ManyToOne(optional = true)
    @JoinColumn(name = "site_id", nullable = true)
    private Site site;

   @ManyToOne
   @JoinColumn(name = "evaluation_id")
   private Evaluation evaluation;

}