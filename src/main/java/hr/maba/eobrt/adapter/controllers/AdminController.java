package hr.maba.eobrt.adapter.controllers;

import hr.maba.eobrt.domain.DTO.ClientDTO;
import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.entity.Location;
import hr.maba.eobrt.usecase.client.FindClient;
import hr.maba.eobrt.usecase.client.NotifiyClient;
import hr.maba.eobrt.usecase.location.FindLocation;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final FindLocation location;

    private final FindClient findClient;

    private final NotifiyClient notifiyClient;

    /**
     * @param id location
     * */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ClientDTO> findBetweenDates(@PathVariable Long id,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                    LocalDateTime fromDate,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                    LocalDateTime toDate){

        Optional<Location> optionalLocation = location.findById(id);

        if (optionalLocation.isPresent()){
            Location location = new Location(optionalLocation);

            return findClient.findBetweenDates(location, fromDate, toDate).stream()
                    .map(this::mapClientToDTO).collect(Collectors.toList());

        }
        return new ArrayList<>();
    }

    @GetMapping("/{id}/clients")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ClientDTO> getClientOfLocation(@PathVariable Long id){

        Optional<Location> optionalLocation = location.findById(id);

        if (optionalLocation.isPresent()){

            Location location = new Location(optionalLocation);

            return findClient.getClientsOfLocation(location).stream().map(this::mapClientToDTO).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @GetMapping("/{id}/notify")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ClientDTO> sendMails(@PathVariable Long id,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                             LocalDateTime fromDate,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                 LocalDateTime toDate){

        Optional<Location> optionalLocation = location.findById(id);

        if (optionalLocation.isPresent()){

            Location location = new Location(optionalLocation);

            List<Client> clientList = findClient.getClientsWihtMail(location, fromDate, toDate);

            notifiyClient.sendNotifications(clientList);

            return clientList.stream().map(this::mapClientToDTO).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    private ClientDTO mapClientToDTO(Client client){
        return new ClientDTO(client.getName(), client.getSurname(), client.getEmail(),
                client.getConctactNumber(), client.getCameAt(), client.getLeaveAt(), client.isNotified());
    }
}
