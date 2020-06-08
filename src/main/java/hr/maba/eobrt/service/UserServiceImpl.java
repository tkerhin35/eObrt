package hr.maba.eobrt.service;

import hr.maba.eobrt.adapter.repository.UserRepository;
import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.domain.port.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
}
