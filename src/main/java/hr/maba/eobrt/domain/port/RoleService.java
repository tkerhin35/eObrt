package hr.maba.eobrt.domain.port;

import hr.maba.eobrt.domain.ERole;
import hr.maba.eobrt.domain.entity.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(ERole name);
}
