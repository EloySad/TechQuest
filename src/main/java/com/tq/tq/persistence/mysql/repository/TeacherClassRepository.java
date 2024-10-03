package com.tq.tq.persistence.mysql.repository;

import com.tq.tq.persistence.mysql.entity.TeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherClassRepository extends JpaRepository <TeacherClass , Long> {
}
