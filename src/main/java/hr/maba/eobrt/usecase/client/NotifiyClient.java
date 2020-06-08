package hr.maba.eobrt.usecase.client;

import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.port.MailService;
import hr.maba.eobrt.service.MailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class NotifiyClient implements MailService {

    private final MailServiceImpl service;

    @Override
    public void sendNotifications(List<Client> clientList) {
        service.sendNotifications(clientList);
    }
}
