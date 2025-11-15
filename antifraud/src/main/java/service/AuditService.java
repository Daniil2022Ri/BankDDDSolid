package service;

import dto.AuditDto;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;

import java.math.BigDecimal;
import java.util.List;

public interface AuditService {

    void logCreate(String entityType, Object newEntity);
    void logUpdate(String entityType, Object oldEntity, Object newEntity);
    AuditDto getAudit(Long id);

}
