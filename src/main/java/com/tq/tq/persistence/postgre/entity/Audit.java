package com.tq.tq.persistence.postgre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

@Setter
@Getter
@Entity
public class Audit {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entityName; // Nombre de la entidad que fue modificada

    @Column(nullable = false)
    private String action; // Acción realizada: CREATE, UPDATE, DELETE

    @Column(nullable = false)
    private Long entityId; // ID de la entidad afectada

    @Column(nullable = false)
    private String modifiedBy; // Usuario que realizó la acción

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdDate; // Fecha de la creación del registro de auditoría

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate; // Fecha de la última modificación (opcional)

    public Audit() {}

    public Audit(String entityName, String action, Long entityId, String modifiedBy) {
        this.entityName = entityName;
        this.action = action;
        this.entityId = entityId;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Date();
    }

}
