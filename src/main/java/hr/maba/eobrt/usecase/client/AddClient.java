package hr.maba.eobrt.usecase.client;

import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.port.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddClient {

    private final ClientService service;

    public void addNewClient(Client client){
        service.addNewClient(client);
    }
}
