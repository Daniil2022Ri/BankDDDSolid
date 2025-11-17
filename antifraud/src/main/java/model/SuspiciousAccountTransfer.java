package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "Account_transfers")
public class SuspiciousAccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "blocked")
    private boolean blocked;

    @Column(name = "suspicious")
    private boolean suspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;
}
