package hr.maba.eobrt.usecase.location;

import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.domain.port.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class FindLocation {

    private LocationService service;

    public Optional<Location> findById(Long id){
        return service.findById(id);
    }

    public Set<Location> findByUser(User user){
        return service.findByUser(user);
    }
}
