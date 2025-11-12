package service;

import model.SuspiciousAccountTransfer;
import model.SuspiciousCardTransfer;
import model.SuspiciousPhoneTransfer;
import org.springframework.stereotype.Service;


@Service
public interface SuspiciousTransferService {
//==========================Model Account==========================================
    SuspiciousAccountTransfer getAccountById(int id);
    SuspiciousAccountTransfer cheсkAccountByBlock(boolean blokeAccount);
    SuspiciousAccountTransfer setBlockSuspiciousAccount(int id, boolean block , String massageLog);
    SuspiciousAccountTransfer setAccountIsSuspicious(int id , boolean accountIsSuspicious , String massageLog);
    SuspiciousAccountTransfer getMassageSuspiciousAccount(int id , boolean accountSuspicious , String massageSuspiciousAccount);

//===========================Model Account=========================================

//===========================Card=========================================
    SuspiciousCardTransfer setBlockCardAccount(int id , boolean blockCard , String massageBlockedReason);
    SuspiciousCardTransfer cheсkCardSuspiciousReason(int id , boolean isSuspicious,String SuspiciousReason);
    SuspiciousCardTransfer setRemoveBlockCardAccount(int id , boolean blockCard , String massageRemoveBlock);
    SuspiciousCardTransfer getMassageSuspiciousCard(int id , boolean setSuspiciousCard , String massageSuspiciousCard);
//===========================Card=========================================

//===========================Phone=========================================
    SuspiciousPhoneTransfer cheсkPhoneIsSuspicious(int id , boolean isSuspicious,String SuspiciousReason);
    SuspiciousPhoneTransfer setBlockPhone(int id , boolean blockPhone , String massageBlock);
    SuspiciousPhoneTransfer setRemoveBlockPhone(int id, boolean removeBlockPhone, String massageRemoveBlack);
    SuspiciousPhoneTransfer getMassageSuspiciousPhone(int id , boolean setSuspiciousPhone , String massageSuspiciousPhone);
//===========================Phone=========================================

}
