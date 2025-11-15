package dto;


import lombok.Data;


@Data
public class SuspiciousCardTransferDto {

    private Long id;
    private boolean isBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;

}
