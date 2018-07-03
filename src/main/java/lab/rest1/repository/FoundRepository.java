package lab.rest1.repository;

import lab.rest1.domain.Found;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundRepository extends JpaRepository<Found, Long> {
}
