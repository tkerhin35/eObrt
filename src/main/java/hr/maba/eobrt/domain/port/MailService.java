package hr.maba.eobrt.domain.port;

import hr.maba.eobrt.domain.entity.Client;

import java.util.List;

public interface MailService {

    void sendNotifications(List<Client> clientList);
}
