package service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.SuspiciousAccountTransferRepository;
import repository.SuspiciousCardTransferRepository;
import repository.SuspiciousPhoneTransferRepository;

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




}
