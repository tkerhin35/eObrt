package hr.maba.eobrt.usecase.location;

import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.port.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddLocation {

    LocationService service;

    public void saveLocation(Location location){
        service.saveNewLocation(location);
    }
}
