package hr.maba.eobrt.domain.port;

import hr.maba.eobrt.domain.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    boolean existsByEmail(String email);

    User saveUser(User user);
}
