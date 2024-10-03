package com.tq.tq.persistence.mysql.key;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class UserSkillKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "skill_id")
    private Long skillId;

    // hashCode, equals, constructors
}
