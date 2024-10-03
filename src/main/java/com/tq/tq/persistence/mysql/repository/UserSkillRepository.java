package com.tq.tq.persistence.mysql.repository;

import com.tq.tq.persistence.mysql.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
}
