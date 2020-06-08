package hr.maba.eobrt.domain.DTO;

import lombok.Data;

@Data
public class UserDTO {

    private String name;

    private String email;


    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }


}
