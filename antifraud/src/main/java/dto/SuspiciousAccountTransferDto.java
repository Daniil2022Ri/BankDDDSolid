package dto;


import lombok.Data;


@Data
public class SuspiciousAccountTransferDto {
    private Long id;
    private boolean IsBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
