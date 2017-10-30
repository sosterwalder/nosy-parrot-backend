package ch.bbv.nosyparrot.backend.configuration.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.bbv.nosyparrot.backend.configuration.authentication.entity.User;
import ch.bbv.nosyparrot.backend.core.entity.UserEntityGateway;


public interface JpaUserEntityGateway extends UserEntityGateway, JpaRepository<User, Long> {}
