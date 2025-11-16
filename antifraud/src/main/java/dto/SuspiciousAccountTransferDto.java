package dto;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SuspiciousAccountTransferDto {
    private Long id;
    private boolean blocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
