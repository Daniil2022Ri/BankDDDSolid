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


public interface SuspiciousTransferService {
    SuspiciousCardTransferDto createCard(SuspiciousCardTransferDto dto);
    SuspiciousPhoneTransferDto createPhone(SuspiciousPhoneTransferDto dto);
    SuspiciousAccountTransferDto createAccount(SuspiciousAccountTransferDto dto);

    SuspiciousCardTransferDto updateCard(Long id, SuspiciousCardTransferDto dto);
    SuspiciousPhoneTransferDto updatePhone(Long id, SuspiciousPhoneTransferDto dto);
    SuspiciousAccountTransferDto updateAccount(Long id, SuspiciousAccountTransferDto dto);

    void delete(Long id, String type);
    List<?> getAll(String type);
    Object getById(Long id, String type);
}
