package hr.maba.eobrt.adapter.repository;

import hr.maba.eobrt.domain.ERole;
import hr.maba.eobrt.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
