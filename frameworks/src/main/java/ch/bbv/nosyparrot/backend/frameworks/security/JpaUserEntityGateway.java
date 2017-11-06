package ch.bbv.nosyparrot.backend.frameworks.security;

import ch.bbv.nosyparrot.backend.frameworks.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserEntityGateway extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

