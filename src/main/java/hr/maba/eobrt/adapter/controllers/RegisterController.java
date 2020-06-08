package hr.maba.eobrt.adapter.controllers;

import hr.maba.eobrt.annotations.ValidEmail;
import hr.maba.eobrt.usecase.user.RegisterNewUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {

    private final RegisterNewUser newUser;

    @PostMapping("/signup")
    public ResponseEntity<?> requestForRegistration(@Valid @RequestBody SignupCommand command){

        return newUser.sendRegistrationRequest(command.getName(), command.getPassword(), command.getEmail(),command.getRoles());
    }


    @Getter
    private static class SignupCommand {

        @NotBlank
        @Size(max = 80)
        private String name;

        @NotBlank
        @Size(min = 6, max = 20)
        private String password;

        @ValidEmail
        private String email;

        @NotEmpty
        private Set<String> roles;
    }
}
