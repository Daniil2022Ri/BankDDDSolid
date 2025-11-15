package repository;

import model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditRepository extends JpaRepository<Audit , Long> {


}
