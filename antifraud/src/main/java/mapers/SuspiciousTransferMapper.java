package mapers;

import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface SuspiciousTransferMapper {
    SuspiciousCardTransfer toCardEntity(SuspiciousCardTransferDto dto);
    SuspiciousCardTransferDto toCardDto(SuspiciousCardTransfer entity);
    SuspiciousPhoneTransfer toPhoneEntity(SuspiciousPhoneTransferDto dto);
    SuspiciousPhoneTransferDto toPhoneDto(SuspiciousPhoneTransfer entity);
    SuspiciousAccountTransfer toAccountEntity(SuspiciousAccountTransferDto dto);
    SuspiciousAccountTransferDto toAccountDto(SuspiciousAccountTransfer entity);
}
