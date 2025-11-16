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
    private final SuspiciousCardTransferRepository cardRepo;
    private final SuspiciousPhoneTransferRepository phoneRepo;
    private final SuspiciousAccountTransferRepository accountRepo;
    private final SuspiciousTransferMapper mapper;

    @Override
    public SuspiciousCardTransferDto createCard(SuspiciousCardTransferDto dto) {
        SuspiciousCardTransfer entity = mapper.toCardEntity(dto);
        return mapper.toCardDto(cardRepo.save(entity));
    }

    @Override
    public SuspiciousPhoneTransferDto createPhone(SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransfer entity = mapper.toPhoneEntity(dto);
        return mapper.toPhoneDto(phoneRepo.save(entity));
    }

    @Override
    public SuspiciousAccountTransferDto createAccount(SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransfer entity = mapper.toAccountEntity(dto);
        return mapper.toAccountDto(accountRepo.save(entity));
    }

    @Override
    public SuspiciousCardTransferDto updateCard(Long id, SuspiciousCardTransferDto dto) {
        SuspiciousCardTransfer entity = cardRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card transfer not found: " + id));
        entity.setBlocked(dto.isBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        return mapper.toCardDto(cardRepo.save(entity));
    }

    @Override
    public SuspiciousPhoneTransferDto updatePhone(Long id, SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransfer entity = phoneRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card transfer not found: " + id));
        entity.setBlocked(dto.isBlocked());
                entity.setSuspicious(dto.isSuspicious());
                entity.setBlockedReason(dto.getBlockedReason());
                entity.setSuspiciousReason(dto.getSuspiciousReason());
        return mapper.toPhoneDto(phoneRepo.save(entity));
    }

    @Override
    public SuspiciousAccountTransferDto updateAccount(Long id, SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransfer entity = accountRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card transfer not found: " + id));
        entity.setBlocked(dto.isBlocked());
                entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        return mapper.toAccountDto(accountRepo.save(entity));
    }



    @Override
    public void delete(Long id, String type) {
        switch (type.toLowerCase()) {
            case "card" -> cardRepo.deleteById(id);
            case "phone" -> phoneRepo.deleteById(id);
            case "account" -> accountRepo.deleteById(id);
            default -> throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

    @Override
    public List<?> getAll(String type) {
        return switch (type.toLowerCase()) {
            case "card" -> cardRepo.findAll().stream().map(mapper::toCardDto).toList();
            case "phone" -> phoneRepo.findAll().stream().map(mapper::toPhoneDto).toList();
            case "account" -> accountRepo.findAll().stream().map(mapper::toAccountDto).toList();
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }

    @Override
    public Object getById(Long id, String type) {
        return switch (type.toLowerCase()) {
            case "card" -> mapper.toCardDto(cardRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Card not found")));
            case "phone" -> mapper.toPhoneDto(phoneRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Phone not found")));
            case "account" -> mapper.toAccountDto(accountRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found")));
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }
}
