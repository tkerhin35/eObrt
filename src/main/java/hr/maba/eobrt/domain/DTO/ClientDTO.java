package hr.maba.eobrt.domain.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientDTO {

    private String name;

    private String surname;

    private String email;

    private String contactNumber;

    private LocalDateTime cameAt;

    private LocalDateTime leaveAt;

    private boolean notified;

    public ClientDTO(){}

    public ClientDTO(String name, String surname, String email, String contactNumber,
                     LocalDateTime cameAt, LocalDateTime leaveAt, boolean notified){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.contactNumber = contactNumber;
        this.cameAt = cameAt;
        this.leaveAt = leaveAt;
        this.notified = notified;
    }

}
