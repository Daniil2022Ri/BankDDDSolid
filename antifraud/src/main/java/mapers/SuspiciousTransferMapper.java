package mapers;

import dto.SuspiciousAccountTransferDto;
import dto.SuspiciousCardTransferDto;
import dto.SuspiciousPhoneTransferDto;
import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.springframework.stereotype.Service;

@Service
public class SuspiciousTransferMapper {

//======= Account Entity => Dto ======
    public SuspiciousAccountTransferDto mappingToDtoSuspiciousAccount(SuspiciousAccountTransfer AccountModel){
        SuspiciousAccountTransferDto AccountSuspiciousDto = new SuspiciousAccountTransferDto();
        AccountSuspiciousDto.setId(AccountModel.getId());
        AccountSuspiciousDto.setSuspiciousReason(AccountModel.getSuspiciousReason());
        AccountSuspiciousDto.setBlockedReason(AccountModel.getBlokedReason());

        return AccountSuspiciousDto;
    }

//======= Phone Entity => Dto ======
    public SuspiciousPhoneTransferDto mappingToDtoSuspiciousPhone(SuspiciousPhoneTransfer PhoneModel){
        SuspiciousPhoneTransferDto PhoneSuspiciousDto = new SuspiciousPhoneTransferDto();
        PhoneSuspiciousDto.setId(PhoneModel.getId());
        PhoneSuspiciousDto.setBlokedReason(PhoneModel.getBlockedReason());
        return PhoneSuspiciousDto;
    }

//======= Phone Entity => Dto ======
    public SuspiciousCardTransferDto mappingToDtoSuspiciousCard(SuspiciousCardTransferDto CardModel){
        SuspiciousCardTransferDto CardSuspiciousDto = new SuspiciousCardTransferDto();
        CardSuspiciousDto.setId(CardModel.getId());
        CardSuspiciousDto.setSuspiciousReason(CardModel.getSuspiciousReason());
        CardSuspiciousDto.setBlockedReason(CardModel.getBlockedReason());
        return CardSuspiciousDto;
    }

//====== Dto => Account =====
    public SuspiciousAccountTransfer mappingToEntitySuspiciousAccount(SuspiciousAccountTransferDto AccountDto){
        SuspiciousAccountTransfer AccountEntitySuspicious =  new SuspiciousAccountTransfer();
        AccountEntitySuspicious.setId(AccountDto.getId());
        AccountEntitySuspicious.setSuspiciousReason(AccountDto.getSuspiciousReason());
        AccountEntitySuspicious.setBlokedReason(AccountDto.getBlockedReason());
        return AccountEntitySuspicious;
    }

//====== Dto => Phone =====
    public SuspiciousPhoneTransfer mappingToEntitySuspiciousPhone(SuspiciousPhoneTransferDto PhoneDto){
        SuspiciousPhoneTransfer PhoneEntitySuspicious = new SuspiciousPhoneTransfer();
        PhoneEntitySuspicious.setId(PhoneDto.getId());
        PhoneEntitySuspicious.setSuspiciousReason(PhoneDto.getBlokedReason());
        PhoneEntitySuspicious.setBlockedReason(PhoneDto.getBlokedReason());
        return PhoneEntitySuspicious;
    }

    //====== Dto => Card =====
    public SuspiciousCardTransfer mappingToEntitySuspiciousPhone(SuspiciousCardTransferDto CardDto){
        SuspiciousCardTransfer CardEntitySuspicious = new SuspiciousCardTransfer();
        CardEntitySuspicious.setId(CardDto.getId());
        CardEntitySuspicious.setSuspiciousReason(CardDto.getSuspiciousReason());
        CardEntitySuspicious.setBlockedReason(CardDto.getBlockedReason());
        return CardEntitySuspicious;
    }

}
