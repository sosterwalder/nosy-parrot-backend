package ch.bbv.nosyparrot.backend.configuration.security;

import ch.bbv.nosyparrot.backend.configuration.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private JpaUserEntityGateway jpaUserEntityGateway;

    public UserDetailsServiceImpl(JpaUserEntityGateway jpaUserEntityGateway) {
        this.jpaUserEntityGateway = jpaUserEntityGateway;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = jpaUserEntityGateway.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }
}
