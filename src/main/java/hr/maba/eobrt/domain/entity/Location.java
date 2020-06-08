package hr.maba.eobrt.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 70)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 20)
    @Column(name = "city_name")
    private String cityName;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @JsonManagedReference
    @ManyToMany(targetEntity = Client.class, mappedBy = "locationList")
    private List<Client> clientList;

    public Location() {
    }

    public Location(String name, String cityName, User user){
        this.name = name;
        this.cityName = cityName;
        this.user = user;
    }

    public Location(Optional<Location> location){
        this.id = location.get().getId();
        this.name = location.get().getName();
        this.cityName = location.get().getCityName();
        this.user = location.get().getUser();
        this.clientList = location.get().getClientList();
    }
}
