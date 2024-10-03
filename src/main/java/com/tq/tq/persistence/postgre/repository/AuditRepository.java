package com.tq.tq.persistence.postgre.repository;

import com.tq.tq.persistence.postgre.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
