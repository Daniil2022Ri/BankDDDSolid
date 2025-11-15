package repository;

import kotlin.OptIn;
import model.SuspiciousAccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.SuspiciousTransferService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SuspiciousAccountTransferRepository extends JpaRepository<SuspiciousAccountTransfer , Long> {

}
