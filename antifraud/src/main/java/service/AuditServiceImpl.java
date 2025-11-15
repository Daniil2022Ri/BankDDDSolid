
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

    @Autowired
    private final SuspiciousAccountTransferRepository accountTransferRepository;
    @Autowired
    private final AuditMapper auditMapper;
    @Autowired
    private final SuspiciousTransferMapper suspiciousTransferMapper;
    @Autowired
    private final AuditRepository auditRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void logCreate(String entityType, Object newEntity) {
        Audit audit = new Audit();
        audit.setEntityType(entityType);
        audit.setOperationType("CREATE");
        audit.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        audit.setCreatedAt(LocalDateTime.now());
        try {
            audit.setNewEntityJson(objectMapper.writeValueAsString(newEntity));
            audit.setEntityJson(null);  // Нет старого
        } catch (JsonProcessingException e) {
            // Обработка ошибки
        }
        auditRepository.save(audit);
    }

    @Override
    public void logUpdate(String entityType, Object oldEntity, Object newEntity) {
        Audit audit = new Audit();
        audit.setEntityType(entityType);
        audit.setOperationType("UPDATE");
        audit.setModifiedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        audit.setModifiedAt(LocalDateTime.now());
        try {
            audit.setEntityJson(objectMapper.writeValueAsString(oldEntity));
            audit.setNewEntityJson(objectMapper.writeValueAsString(newEntity));
        } catch (JsonProcessingException e) {
            // Обработка ошибки
        }
        auditRepository.save(audit);
    }

    @Override
    public AuditDto getAudit(Long id) {
        Audit audit = auditRepository.findById(id).orElseThrow();
        return auditMapper.toDto(audit);
    }

}
