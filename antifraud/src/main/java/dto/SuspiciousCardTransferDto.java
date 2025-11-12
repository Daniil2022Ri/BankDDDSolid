package dto;


import lombok.Data;


@Data
public class SuspiciousCardTransferDto {

    private int id;
    private boolean isBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;

}
