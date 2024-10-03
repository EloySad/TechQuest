package com.tq.tq.persistence.postgre.entity.listener;

import com.tq.tq.persistence.mysql.entity.BaseEntity;
import com.tq.tq.persistence.postgre.entity.Audit;
import com.tq.tq.persistence.postgre.repository.AuditRepository;
import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AuditListener {

    @Setter
    private static ApplicationContext applicationContext;

    @PostPersist
    public void afterCreate(Object entity) {
        registerAction(entity, "CREATE");
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        registerAction(entity, "UPDATE");
    }

    @PostRemove
    public void afterDelete(Object entity) {
        registerAction(entity, "DELETE");
    }

    private void registerAction(Object entity, String action) {
        Long entityId = getEntityId(entity);

        // Verificar que el ID no sea null
        if (entityId == null) {
            throw new IllegalArgumentException("Entity ID is null for action: " + action);
        }

        AuditRepository auditRepository = applicationContext.getBean(AuditRepository.class);

        Audit audit = new Audit(
                entity.getClass().getSimpleName(),  // Nombre de la entidad
                action,                             // Acción: CREATE, UPDATE, DELETE
                entityId,                           // Obtener el ID de la entidad
                "system"                            // Usuario, puede ser dinámico
        );
        auditRepository.save(audit);
    }

    private Long getEntityId(Object entity) {
        if (entity instanceof BaseEntity) {
            return ((BaseEntity) entity).getId();
        }
        return null; // Devuelve null si no es una BaseEntity
    }
}
