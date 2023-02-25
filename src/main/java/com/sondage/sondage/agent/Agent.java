package com.sondage.sondage.agent;

import com.sondage.sondage.site.Site;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "_agent")
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="agent_id",
            updatable = false
    )
    private Long id;
    @Column(
            name="fullName",
            nullable = false
    )
    private String fullName;
    @Column(
            name="email",
            nullable = false
    )
    private String email;

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;


}
