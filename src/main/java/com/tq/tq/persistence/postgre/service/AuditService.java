package com.tq.tq.persistence.postgre.service;

import com.tq.tq.persistence.postgre.entity.Audit;
import com.tq.tq.persistence.postgre.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    // Métodos del servicio que utilizan auditRepository

    public void saveAudit(Audit audit) {
        auditRepository.save(audit);
    }

    // Otros métodos según sea necesario
}
