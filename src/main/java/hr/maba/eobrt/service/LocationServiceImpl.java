package hr.maba.eobrt.service;

import hr.maba.eobrt.adapter.repository.LocationRepository;
import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.domain.port.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    @Override
    public Optional<Location> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Location> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public void saveNewLocation(Location location) {
        repository.save(location);
    }

}
