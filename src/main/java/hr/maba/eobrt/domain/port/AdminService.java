package hr.maba.eobrt.domain.port;

import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.entity.Location;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminService {

    List<Client> findClientsBetweenDates(LocalDateTime fromDate, LocalDateTime toDate, Location location);

    List<Client> getClientsOfLocation(Location location);

    List<Client> getClientsWithMail(Location location, LocalDateTime fromDate, LocalDateTime toDate);
}
