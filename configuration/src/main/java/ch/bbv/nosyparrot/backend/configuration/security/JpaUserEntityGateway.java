package ch.bbv.nosyparrot.backend.configuration.security;

import ch.bbv.nosyparrot.backend.configuration.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserEntityGateway extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

