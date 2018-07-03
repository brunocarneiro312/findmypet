package lab.rest1.repository;

import lab.rest1.domain.Lost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostRepository extends JpaRepository<Lost, Long> {
}
