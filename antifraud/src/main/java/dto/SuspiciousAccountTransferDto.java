package dto;


import lombok.Data;


@Data
public class SuspiciousAccountTransferDto {
    private int id;
    private boolean IsBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
