package ch.bbv.nosyparrot.backend.configuration.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    private JpaUserEntityGateway jpaUserEntityGateway;
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(JpaUserEntityGateway jpaUserEntityGateway) {
        this.jpaUserEntityGateway = jpaUserEntityGateway;
    }

}
