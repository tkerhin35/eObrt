package hr.maba.eobrt.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_number")
    private String conctactNumber;

    @Column(name = "came_at")
    @JsonFormat(pattern = "dd.MM.yyyy.THH:mm:ss")
    private LocalDateTime cameAt;

    @Column(name = "leave_at")
    @JsonFormat(pattern = "dd.MM.yyyy.THH:mm:ss")
    private LocalDateTime leaveAt;

    @ToString.Exclude
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, targetEntity = Location.class)
    @JoinTable(
            name = "client_locations",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> locationList;

    @Column(name = "notified")
    private boolean notified;

    public Client(){}

    public Client(String name, String surname, String email, String conctactNumber,
                  LocalDateTime cameAt, LocalDateTime leaveAt){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.conctactNumber = conctactNumber;
        this.cameAt = cameAt;
        this.leaveAt = leaveAt;
        this.notified = false;
    }

    public Client(Optional<Client> client){
        this.id = client.get().getId();
        this.name = client.get().getName();
        this.surname = client.get().getSurname();
        this.email = client.get().getEmail();
        this.conctactNumber = client.get().getConctactNumber();
        this.cameAt = client.get().getCameAt();
        this.leaveAt = client.get().getLeaveAt();
        this.locationList = client.get().getLocationList();
        this.notified = client.get().isNotified();
    }


}
