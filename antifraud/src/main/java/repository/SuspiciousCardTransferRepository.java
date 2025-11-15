package repository;


import model.SuspiciousCardTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SuspiciousCardTransferRepository extends JpaRepository<SuspiciousCardTransfer, Long> {



}
