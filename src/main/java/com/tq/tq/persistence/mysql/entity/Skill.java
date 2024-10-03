package com.tq.tq.persistence.mysql.entity;
import com.tq.tq.persistence.mysql.enums.SkillType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillType type; // Enum for the type of skill

    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "last_modified_at")
    @UpdateTimestamp
    private Timestamp lastModifiedAt;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastModifiedAt(Timestamp lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
