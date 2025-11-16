
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.AuditDto;
import lombok.AllArgsConstructor;
import mapers.AuditMapper;
import mapers.SuspiciousTransferMapper;
import model.Audit;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AuditRepository;
import repository.SuspiciousAccountTransferRepository;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper;
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
