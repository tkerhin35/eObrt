package hr.maba.eobrt.service;

import hr.maba.eobrt.adapter.repository.ClientRepository;
import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.port.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ClientRepository repository;

    @Override
    public List<Client> findClientsBetweenDates(LocalDateTime fromDate, LocalDateTime toDate, Location location) {
        return repository.findByCameAtBetweenAndLocationList(fromDate, toDate, location);
    }

    @Override
    public List<Client> getClientsOfLocation(Location location) {
        return repository.findByLocationList(location);
    }

    @Override
    public List<Client> getClientsWithMail(Location location, LocalDateTime fromDate, LocalDateTime toDate) {
        return repository.findByLocationListAndEmailIsNotNullAndCameAtBetween(location, fromDate, toDate);
    }
}
