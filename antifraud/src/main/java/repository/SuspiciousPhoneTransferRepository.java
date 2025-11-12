package repository;

import model.SuspiciousPhoneTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuspiciousPhoneTransferRepository extends JpaRepository<SuspiciousPhoneTransfer , Long> {

    List<SuspiciousPhoneTransfer> findByPhoneIdSuspicious(int id);
    List<SuspiciousPhoneTransfer> findByPhoneMassageSuspicious(String massage);

}
