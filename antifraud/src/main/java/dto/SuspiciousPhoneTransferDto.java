package dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class SuspiciousPhoneTransferDto {

    private Long id;
    private boolean isBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
