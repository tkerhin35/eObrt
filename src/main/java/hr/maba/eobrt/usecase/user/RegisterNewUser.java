package hr.maba.eobrt.usecase.user;

import hr.maba.eobrt.domain.ERole;
import hr.maba.eobrt.domain.entity.Role;
import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.domain.port.RoleService;
import hr.maba.eobrt.domain.port.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class RegisterNewUser {

    private final UserService userService;

    private final RoleService roleService;

    private final PasswordEncoder encoder;


    public ResponseEntity<?> sendRegistrationRequest(String name, String password, String email, Set<String> strRoles){

        if (userService.existsByEmail(email)){
            return ResponseEntity.badRequest()
                    .body("Email already taken");
        }
        User user = new User(name, encoder.encode(password), email);

        Set<Role> roles = convertFromStringToRole(strRoles);

        user.setRoles(roles);
        userService.saveUser(user);

        return ResponseEntity.ok("Registered successfully");
    }


    private Set<Role> convertFromStringToRole(Set<String> strRoles){

        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        return roles;
    }

}
