package hr.maba.eobrt.usecase.client;

import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.port.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class FindClient {

    private final AdminService service;

    public List<Client> findBetweenDates(Location location,LocalDateTime fromDate, LocalDateTime toDate){
        return service.findClientsBetweenDates(fromDate, toDate, location);
    }

    public List<Client> getClientsOfLocation(Location location){
        return service.getClientsOfLocation(location);
    }

    public List<Client> getClientsWihtMail(Location location, LocalDateTime fromDate, LocalDateTime toDate){
        return service.getClientsWithMail(location, fromDate, toDate);
    }
}
