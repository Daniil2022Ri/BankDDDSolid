package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "transfer_audit_id")
    private Long transferAuditId;
    @Column(name = "profile_audit_id")
    private Long profileAuditId;
    @Column(name = "account_audit_id")
    private Long accountAuditId;
    @Column(name = "anti_fraud_audit_id")
    private Long antiFraudAuditId;
    @Column(name = "public_bank_info_audit_id")
    private Long publicBankInfoAuditId;
    @Column(name = "authorization_audit_id")
    private Long authorizationAuditId;
}
