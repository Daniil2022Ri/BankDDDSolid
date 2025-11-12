package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
@Table(name = "Account_transfets")
public class SuspiciousAccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bloked")
    private boolean bloked;

    @Column(name = "suspicious")
    private boolean suspicious;

    @Column(name = "bloked_reason")
    private String blokedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;
}
