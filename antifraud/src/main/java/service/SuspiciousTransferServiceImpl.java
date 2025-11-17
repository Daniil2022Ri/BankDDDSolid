package service;

import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapers.SuspiciousTransferMapper;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.SuspiciousAccountTransferRepository;
import repository.SuspiciousCardTransferRepository;
import repository.SuspiciousPhoneTransferRepository;


import java.util.List;


@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class SuspiciousTransferServiceImpl implements SuspiciousTransferService{

    private final SuspiciousCardTransferRepository cardRepo;
    private final SuspiciousPhoneTransferRepository phoneRepo;
    private final SuspiciousAccountTransferRepository accountRepo;
    private final SuspiciousTransferMapper mapper;

    @Override
    public SuspiciousCardTransferDto createCard(SuspiciousCardTransferDto dto) {

        log.info("Создание подозрительной транзакции в модели Карты: Card={id}");
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
                .orElseThrow(() -> new EntityNotFoundException("Подозрительный перевод на карту не найден: " + id));
        entity.setBlocked(dto.isBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        return mapper.toCardDto(cardRepo.save(entity));
    }

    @Override
    public SuspiciousPhoneTransferDto updatePhone(Long id, SuspiciousPhoneTransferDto dto) {
        SuspiciousPhoneTransfer entity = phoneRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Подозрительный перевод на телефон не найден: " + id));
        entity.setBlocked(dto.isBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        return mapper.toPhoneDto(phoneRepo.save(entity));
    }

    @Override
    public SuspiciousAccountTransferDto updateAccount(Long id, SuspiciousAccountTransferDto dto) {
        SuspiciousAccountTransfer entity = accountRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Подозрительный перевод на аккаунт не найден: " + id));
        entity.setBlocked(dto.isBlocked());
        entity.setSuspicious(dto.isSuspicious());
        entity.setBlockedReason(dto.getBlockedReason());
        entity.setSuspiciousReason(dto.getSuspiciousReason());
        return mapper.toAccountDto(accountRepo.save(entity));
    }



    @Override
    public void deleteSuspiciousTransfer(Long id, String type) {
        switch (type.toLowerCase()) {
            case "card" -> cardRepo.deleteById(id);
            case "phone" -> phoneRepo.deleteById(id);
            case "account" -> accountRepo.deleteById(id);
            default -> throw new IllegalArgumentException("Ошибка запроса удаления: " + type);
        }
    }

    @Override
    public List<?> getAll(String type) {
        return switch (type.toLowerCase()) {
            case "card" -> cardRepo.findAll().stream().map(mapper::toCardDto).toList();
            case "phone" -> phoneRepo.findAll().stream().map(mapper::toPhoneDto).toList();
            case "account" -> accountRepo.findAll().stream().map(mapper::toAccountDto).toList();
            default -> throw new IllegalArgumentException("Ошибка запроса на получение:" + type);
        };
    }

    @Override
    public Object getById(Long id, String type) {
        return switch (type.toLowerCase()) {
            case "card" -> mapper.toCardDto(cardRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Карта не найдена")));
            case "phone" -> mapper.toPhoneDto(phoneRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Телефон не найден")));
            case "account" -> mapper.toAccountDto(accountRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Аккаунт не найден")));
            default -> throw new IllegalArgumentException("Ошибка запроса на получение по ID:" + type);
        };
    }
}
