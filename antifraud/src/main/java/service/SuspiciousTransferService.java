package service;

import dto.AuditDto;
import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public interface SuspiciousTransferService {

    SuspiciousCardTransferDto createCardTransfer(SuspiciousCardTransferDto dto);
    SuspiciousPhoneTransferDto createPhoneTransfer(SuspiciousPhoneTransferDto dto);
    SuspiciousAccountTransferDto createAccountTransfer(SuspiciousAccountTransferDto dto);

    SuspiciousCardTransferDto updateCardTransfer(Integer id, SuspiciousCardTransferDto dto);
    SuspiciousPhoneTransferDto updatePhoneTransfer(Integer id, SuspiciousPhoneTransferDto dto);
    SuspiciousAccountTransferDto updateAccountTransfer(Integer id, SuspiciousAccountTransferDto dto);

    void deleteTransfer(String type, Integer id);

    Object getTransfer(String type, Integer id);

}
