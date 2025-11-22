package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.time.LocalTime;

@Entity
@Builder
@AllArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Entity" , length = 40)
    private String entityType;
    @Column(name = "Operation" , length = 255)
    private String operationType;
    @Column(name = "created" , length = 255)
    private String createdBy;
    @Column(name = "modified" , length = 255)
    private String modifiedBy;
    @Column(name = "Time create")
    private LocalTime createdAt;
    @Column(name = "Time modified")
    private LocalTime modifiedAt;
    @Column(name = "New Entity Json")
    private String newEntityJson;
    @Column(name = "Entity Json")
    private String entityJson;
}
