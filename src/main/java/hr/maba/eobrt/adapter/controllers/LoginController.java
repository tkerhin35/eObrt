package hr.maba.eobrt.adapter.controllers;

import hr.maba.eobrt.usecase.user.LoginUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final LoginUser user;

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginCommand command){
        return user.login(command.getEmail(), command.getPassword());
    }

    @Data
    private static class LoginCommand{

        @NotBlank
        private String email;

        @NotBlank
        private String password;
    }
}
