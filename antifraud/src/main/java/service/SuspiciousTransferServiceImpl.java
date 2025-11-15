package service;

import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import mapers.SuspiciousTransferMapper;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.SuspiciousAccountTransferRepository;
import repository.SuspiciousCardTransferRepository;
import repository.SuspiciousPhoneTransferRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class SuspiciousTransferServiceImpl implements SuspiciousTransferService{

    @Autowired
    private final SuspiciousCardTransferRepository transferCardRepository;

    @Autowired
    private final SuspiciousPhoneTransferRepository transferPhoneRepository;

    @Autowired
    private final SuspiciousAccountTransferRepository transferAccountRepository;

    @Autowired
    private final AuditService auditService;

    @Autowired
    private final SuspiciousTransferMapper transferMapper;



    @Override
    @Transactional
    public SuspiciousCardTransferDto createCardTransfer(SuspiciousCardTransferDto dto) {
        SuspiciousCardTransfer entity = transferMapper.toCardEntity(dto);
        entity = transferCardRepository.save(entity);
        return transferMapper.toCardDto(entity);
    }

    @Override
    @Transactional
    public SuspiciousPhoneTransferDto createPhoneTransfer(SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransfer entity = transferMapper.toPhoneEntity(dto);
        entity = transferPhoneRepository.save(entity);
        return transferMapper.toPhoneDto(entity);
    }

    @Override
    @Transactional
    public SuspiciousAccountTransferDto createAccountTransfer(SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransfer entity = transferMapper.toAccountEntity(dto);
        entity = transferAccountRepository.save(entity);
        return transferMapper.toAccountDto(entity);
    }

    @Override
    @Transactional
    public SuspiciousCardTransferDto updateCardTransfer(Integer id, SuspiciousCardTransferDto dto) {
        SuspiciousCardTransfer entity = transferCardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Card transfer not found"));
        entity.setCardBlocked(dto.isCardBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        entity = transferCardRepository.save(entity);
        return transferMapper.toCardDto(entity);
    }

    @Override
    @Transactional
    public SuspiciousPhoneTransferDto updatePhoneTransfer(Integer id, SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransfer entity = phoneRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Phone transfer not found"));
        entity.setBlocked(dto.isBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        entity = phoneRepo.save(entity);
        return mapper.toPhoneDto(entity);
    }

    @Override
    @Transactional
    public SuspiciousAccountTransferDto updateAccountTransfer(Integer id, SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransfer entity = accountRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Account transfer not found"));
        entity.setBlocked(dto.isBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        entity = accountRepo.save(entity);
        return mapper.toAccountDto(entity);
    }

    @Override
    public void deleteTransfer(String type, Integer id) {
        switch (type.toLowerCase()) {
            case "card":
                cardRepo.deleteById(id);
                break;
            case "phone":
                phoneRepo.deleteById(id);
                break;
            case "account":
                accountRepo.deleteById(id);
                break;
            default:
                throw new IllegalArgumentException("Invalid transfer type");
        }
    }

    @Override
    public Object getTransfer(String type, Integer id) {
        switch (type.toLowerCase()) {
            case "card":
                return mapper.toCardDto(cardRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Card transfer not found")));
            case "phone":
                return mapper.toPhoneDto(phoneRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Phone transfer not found")));
            case "account":
                return mapper.toAccountDto(accountRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Account transfer not found")));
            default:
                throw new IllegalArgumentException("Invalid transfer type");
        }
    }
}
