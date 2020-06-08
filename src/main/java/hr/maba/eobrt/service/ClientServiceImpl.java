package hr.maba.eobrt.service;

import hr.maba.eobrt.adapter.repository.ClientRepository;
import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.port.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public void addNewClient(Client client) {
            repository.save(client);
    }

}
