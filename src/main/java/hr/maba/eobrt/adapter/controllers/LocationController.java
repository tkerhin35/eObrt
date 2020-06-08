package hr.maba.eobrt.adapter.controllers;

import hr.maba.eobrt.domain.DTO.LocationDTO;
import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.usecase.location.AddLocation;
import hr.maba.eobrt.usecase.location.FindLocation;
import hr.maba.eobrt.usecase.user.FindUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {

    private FindLocation getLocation;

    private AddLocation addLocation;

    private FindUser userUS;

    /* *
    * @param id of user
    * @return list of users locations
    * */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public List<LocationDTO> getUsersLocations(@PathVariable Long id){

        Optional<User> optionalUser = userUS.findById(id);

        if(optionalUser.isPresent()){
            User user = new User(optionalUser);

            return getLocation.findByUser(user).stream().map(this::mapToDTO).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    /**
     * add user location
     * @param id of user
     */
    @PostMapping("/{id}/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LocationDTO> addLocation(@PathVariable Long id,
                                         @Valid @RequestBody LocationCommand command){

        Optional<User> optionalUser = userUS.findById(id);

        if (optionalUser.isPresent()){
            User user = new User(optionalUser);

            Location newLocation = new Location(command.getName(), command.getCityName(), user);

            addLocation.saveLocation(newLocation);

            return ResponseEntity.ok(mapToDTO(newLocation));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    private LocationDTO mapToDTO(Location location){
        return new LocationDTO(location.getName(), location.getCityName());
    }

    @Getter
    private static class LocationCommand{

        @NotBlank
        private String name;

        @NotBlank
        private String cityName;
    }
}
