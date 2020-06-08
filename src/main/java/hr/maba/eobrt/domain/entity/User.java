package hr.maba.eobrt.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String name, String password, String email, boolean enabled, Set<Role> roles){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.enabled = false;
        this.roles = roles;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(Optional<User> user){
        this.id = user.get().getId();
        this.name = user.get().getName();
        this.password = user.get().getPassword();
        this.email = user.get().getPassword();
        this.roles = user.get().getRoles();
        this.enabled = user.get().isEnabled();
    }
}
