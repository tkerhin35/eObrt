package hr.maba.eobrt.service;

import hr.maba.eobrt.adapter.repository.RoleRepository;
import hr.maba.eobrt.domain.ERole;
import hr.maba.eobrt.domain.entity.Role;
import hr.maba.eobrt.domain.port.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public Optional<Role> findByName(ERole name) {
        return repository.findByName(name);
    }
}
