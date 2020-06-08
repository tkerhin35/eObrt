package hr.maba.eobrt.adapter.repository;

import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findById(Long id);

    Set<Location> findByUser(User user);
    
}
