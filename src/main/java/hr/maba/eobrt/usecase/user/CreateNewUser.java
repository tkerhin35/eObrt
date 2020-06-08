package hr.maba.eobrt.usecase.user;

import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.domain.port.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateNewUser {

    private final UserService userService;

    public void createUser(User user){
        userService.saveUser(user);
    }
}
