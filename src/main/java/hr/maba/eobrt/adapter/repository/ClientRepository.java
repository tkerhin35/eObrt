package hr.maba.eobrt.adapter.repository;

import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByLocationList(Location location);

    List<Client> findByCameAtBetweenAndLocationList(LocalDateTime fromDate, LocalDateTime toDate, Location location);

    List<Client> findByLocationListAndEmailIsNotNullAndCameAtBetween(Location location, LocalDateTime fromDate, LocalDateTime toDate);
}
