package com.sondage.sondage.ask;

import com.sondage.sondage.survey.Survey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_ask")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="ask_id",
            updatable = false
    )
    private Long id;
    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "survey_id" )//, nullable = false)
    private Survey survey;
}
