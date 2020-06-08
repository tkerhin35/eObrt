package hr.maba.eobrt.adapter.controllers;

import hr.maba.eobrt.domain.DTO.ClientDTO;
import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.usecase.client.AddClient;
import hr.maba.eobrt.usecase.client.FindClient;
import hr.maba.eobrt.usecase.location.FindLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private FindLocation location;

    private AddClient add;

    private FindClient findClient;

    /**
     * add new client to location
     * @param id of location
     *
     */
    @PostMapping("/{id}/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ClientDTO> addClient(@PathVariable Long id,
                                       @Valid @RequestBody ClientCommand command){

        Optional<Location> optionalClientLocation = location.findById(id);

        if (optionalClientLocation.isPresent()){
            Location clientLocation = new Location(optionalClientLocation);

            List<Location> locationList = new ArrayList<>();
            locationList.add(clientLocation);

            Client newClient = new Client(command.getName(),command.getSurname(), command.getEmail(),
                    command.getContactNumber(), command.getCameAt(), command.getLeaveAt());

            newClient.setLocationList(locationList);

            add.addNewClient(newClient);

            return ResponseEntity.status(HttpStatus.OK).body(mapClientToDTO(newClient));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @Getter
    static class ClientCommand{

        @NotBlank
        private String name;

        @NotBlank
        private String surname;

        private String email;

        private String contactNumber;

        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime cameAt;

        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime leaveAt;
    }

    private ClientDTO mapClientToDTO(Client client){
        return new ClientDTO(client.getName(), client.getSurname(), client.getEmail(),
                client.getConctactNumber(), client.getCameAt(), client.getLeaveAt(), client.isNotified());
    }
}
