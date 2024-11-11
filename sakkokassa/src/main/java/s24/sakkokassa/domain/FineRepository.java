package s24.sakkokassa.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Long> {
    List<Fine> findByPlayerIdAndPaid(Long playerId, boolean paid);
}
