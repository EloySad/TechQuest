package com.tq.tq.persistence.mysql.entity;
import com.tq.tq.persistence.mysql.enums.MissionDifficulty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "missions")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionDifficulty difficulty; // Enum for difficulty levels

    @ManyToMany
    @JoinTable(
            name = "mission_skills",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skillsRequired;

    @ManyToOne
    @JoinColumn(name = "assigned_to", nullable = false)
    private User assignedTo; // Referencia a User, con role = "STUDENT"

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "last_modified_at")
    @UpdateTimestamp
    private Timestamp lastModifiedAt;

    // Getters and Setters
}
