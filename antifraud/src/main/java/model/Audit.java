package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "anti_fraud")
public class Audit {

    @Column( name = "enity_type" , length = 40)
    private String entityType;

    @Column(name = "operation_type" , length = 255)
    private String operationType;

    @Column(name = "created_by" , length = 255)
    private String createdBy;

    @Column(name = "modified_by" , length = 255)
    private String modifiedBy;

    @Column(name = "created_at")
    private LocalTime createdAt;

    @Column(name = "modified_at")
    private LocalTime modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @Column(name = "entity_json")
    private String entityJson;


}
