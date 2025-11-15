package mapers;

import dto.AuditDto;
import model.Audit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditMapper {
    Audit toEntity(AuditDto dto);
    AuditDto toDto(Audit entity);
}
