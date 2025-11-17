package Unit;


import dto.SuspiciousCardTransferDto;
import mapers.SuspiciousTransferMapper;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.SuspiciousAccountTransferRepository;
import repository.SuspiciousCardTransferRepository;
import repository.SuspiciousPhoneTransferRepository;
import service.SuspiciousTransferService;
import service.SuspiciousTransferServiceImpl;

import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class SuspiciousTransferControllerTest {
    @Mock
    private SuspiciousTransferService suspiciousTransferService;

    @InjectMocks
    private SuspiciousTransferServiceImpl serviceImpl;
    @Mock
    private SuspiciousAccountTransferRepository suspiciousAccountTransferRepository;
    @Mock
    private SuspiciousCardTransferRepository suspiciousCardTransferRepository;
    @Mock
    private SuspiciousPhoneTransferRepository suspiciousPhoneTransferRepository;
    @Mock
    private SuspiciousTransferMapper mapper;

    private final Long TEST_ID = 1L;
    private final boolean BLOCKED_TRUE = true;
    private final boolean BLOCKED_FALSE = false;
    private final boolean SUSPICIOUS_TRUE = true;
    private final boolean SUSPICIOUS_FALSE = false;
    private final String SUSPICIOUS_REASON = "Подозрительные действия";
    private final String BLOCKED_REASON = "Причина блокировки Подтвержденные незаконные переводы";

    @Test
    void createCard(){
        SuspiciousCardTransferDto inputCardDto = createTestCardDto();
        SuspiciousCardTransfer inputCard = createTestCardEntity();
        
    }


    private SuspiciousCardTransferDto createTestCardDto(){
        return SuspiciousCardTransferDto.builder()
                .id(TEST_ID)
                .blocked(BLOCKED_TRUE)
                .isSuspicious(SUSPICIOUS_TRUE)
                .blockedReason(BLOCKED_REASON)
                .suspiciousReason(SUSPICIOUS_REASON).build();
    }

    private SuspiciousCardTransfer createTestCardEntity(){
        return SuspiciousCardTransfer.builder()
                .id(TEST_ID)
                .blocked(BLOCKED_TRUE)
                .suspicious(SUSPICIOUS_TRUE)
                .suspiciousReason(SUSPICIOUS_REASON)
                .blockedReason(BLOCKED_REASON).build();
    }


}
