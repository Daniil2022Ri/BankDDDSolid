package mapers;

import dto.AuditDto;
import model.Audit;
import org.springframework.stereotype.Service;

@Service
public class AuditMapper {

    public AuditDto AuditMappingDto(Audit auditEntity){
        AuditDto auditDtoMapping = new AuditDto();
        auditDtoMapping.setCreatedAt(auditEntity.getCreatedAt());
        auditDtoMapping.setEntityJson(auditEntity.getEntityJson());
        auditDtoMapping.setModifiedBy(auditEntity.getModifiedBy());
        auditDtoMapping.setModifiedAt(auditEntity.getModifiedAt());
        auditDtoMapping.setNewEntityJson(auditEntity.getNewEntityJson());
        auditDtoMapping.setOperationType(auditEntity.getOperationType());
        return auditDtoMapping;
    }

    public Audit AuditMappingEntity(AuditDto auditDto){
        Audit auditEntityMapping = new Audit();
        auditEntityMapping.setCreatedAt(auditDto.getCreatedAt());
        auditEntityMapping.setEntityJson(auditDto.getEntityJson());
        auditEntityMapping.setModifiedBy(auditDto.getModifiedBy());
        auditEntityMapping.setModifiedAt(auditDto.getModifiedAt());
        auditEntityMapping.setNewEntityJson(auditDto.getNewEntityJson());
        auditEntityMapping.setOperationType(auditDto.getOperationType());
        return auditEntityMapping;
    }
}
