
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import mapers.AuditMapper;
import model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuditRepository;



import java.time.LocalTime;


@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {

    @Autowired
    private final AuditRepository auditRepository;
    @Autowired
    private final AuditMapper auditMapper;
    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void logCreate(String entityType, Object newEntity, String username) {
        Audit audit = new Audit();
        audit.setEntityType(entityType);
        audit.setOperationType("CREATE");
        audit.setCreatedBy(username);
        audit.setCreatedAt(LocalTime.now());
        audit.setNewEntityJson(toJson(newEntity));
        auditRepository.save(audit);
    }

    @Override
    public void logUpdate(String entityType, Object oldEntity, Object newEntity, String username) {
        Audit audit = new Audit();
        audit.setEntityType(entityType);
        audit.setOperationType("UPDATE");
        audit.setModifiedBy(username);
        audit.setModifiedAt(LocalTime.now());
        audit.setEntityJson(toJson(oldEntity));
        audit.setNewEntityJson(toJson(newEntity));
        auditRepository.save(audit);
    }

    private String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }
}
