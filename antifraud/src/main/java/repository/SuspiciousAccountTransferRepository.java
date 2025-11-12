package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.SuspiciousTransferService;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuspiciousAccountTransferRepository extends JpaRepository<SuspiciousAccountTransferRepository , Long> {



    List<SuspiciousTransferService> findByFormAccount(String fromAccount); // подозрительный аккаунт

    List<SuspiciousTransferService> findByStatusSuspicious(boolean suspicious); // подозрительный

    Optional<SuspiciousTransferService> findByTransactionAcountId(int id); //Найти по id аккаунт


}
