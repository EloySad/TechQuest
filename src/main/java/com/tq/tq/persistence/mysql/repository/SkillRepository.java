package com.tq.tq.persistence.mysql.repository;

import com.tq.tq.persistence.mysql.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill , Long> {
}
