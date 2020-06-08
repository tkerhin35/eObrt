package hr.maba.eobrt.domain.payload;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {

    private String accessToken;

    private String type = "Bearer";

    private String username;

    private String email;

    private List<String> roles;

    public JwtResponse(String accessToken, String username, String email, List<String> roles) {
        this.accessToken = accessToken;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
