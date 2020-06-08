package hr.maba.eobrt.service;

import hr.maba.eobrt.domain.entity.Client;
import hr.maba.eobrt.domain.port.MailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    /*
    @Value("${mail.address.from}")
    private String emailFrom;

    @Value("${mail.subject}")
    private String subject;

    @Value("${mail.body}")
    private String body;
    
     */

    @Override
    public void sendNotifications(List<Client> clientList) {

        for (Client client : clientList) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(client.getEmail());
            mailMessage.setFrom("${mail.address.from}");
            mailMessage.setSubject("${mail.subject}");
            mailMessage.setText("${mail.body}");

            mailSender.send(mailMessage);

            client.setNotified(true);
        }
    }
}
