package com.sondage.sondage.survey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
    @Table(name = "_survey")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Survey {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Column(name = "created_at")
        private Date createdAt;

        @Column(name = "updated_at")
        private Date updatedAt;

        /*
        @ManyToOne
        private User createdBy;
*/
        @PrePersist
        protected void onCreate() {
            createdAt = new Date();
        }

        @PreUpdate
        protected void onUpdate() {
            updatedAt = new Date();
        }


}
