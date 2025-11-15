package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
@AllArgsConstructor
@Table(name = "Account_transfets")
public class SuspiciousAccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "blocked")
    private boolean blocked;

    @Column(name = "suspicious")
    private boolean suspicious;

    @Column(name = "bloked_reason")
    private String blokedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;
}
