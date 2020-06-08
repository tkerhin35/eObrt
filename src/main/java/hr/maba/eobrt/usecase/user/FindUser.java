package hr.maba.eobrt.usecase.user;

import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.domain.port.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindUser {

    private final UserService service;

    public Optional<User> findByEmail(String email){
        return service.findByEmail(email);
    }

    public Optional<User> findById(Long id) { return service.findById(id); }

}
