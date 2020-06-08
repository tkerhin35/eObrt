package hr.maba.eobrt.security;

import hr.maba.eobrt.domain.entity.User;
import hr.maba.eobrt.usecase.user.FindUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private FindUser findUser;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findUser.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usernem with this email not found " + email));

        return UserDetailsImpl.build(user);
    }
}
