package hr.maba.eobrt.domain.port;

import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.entity.User;

import java.util.Optional;
import java.util.Set;

public interface LocationService {

    Optional<Location> findById(Long id);

    Set<Location> findByUser(User user);

    void saveNewLocation(Location location);
}
