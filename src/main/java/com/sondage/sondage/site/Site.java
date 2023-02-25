package com.sondage.sondage.site;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "_site")
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="site_id",
            updatable = false
    )
    private Long id;
    @Column(
            name="name",
            nullable = false
            )
    private String name;
}
