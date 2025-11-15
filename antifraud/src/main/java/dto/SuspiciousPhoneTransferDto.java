package dto;


import lombok.Data;


@Data
public class SuspiciousPhoneTransferDto {

    private Long id;
    private boolean isBlocked;
    private boolean isSuspicious;
    private String blokedReason;

}
