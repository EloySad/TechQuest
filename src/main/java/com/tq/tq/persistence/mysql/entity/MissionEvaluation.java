package com.tq.tq.persistence.mysql.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "mission_evaluations")
public class MissionEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student; // Referencia a User, con role = "STUDENT"

    @Column(nullable = false)
    private String performance;

    @Column(name = "completed_at", nullable = false)
    private Timestamp completedAt;

    @Column(name = "evaluation_date", nullable = false)
    private Timestamp evaluationDate;

    // Getters and Setters
}
