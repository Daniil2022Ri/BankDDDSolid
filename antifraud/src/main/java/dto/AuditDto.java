package dto;

import lombok.Data;

import java.time.LocalTime;


@Data
public class AuditDto {

    private String entityType;
    private String operationType;
    private String createdBy;
    private String modifiedBy;
    private LocalTime createdAt;
    private LocalTime modifiedAt;
    private String newEntityJson;
    private String entityJson;
}
