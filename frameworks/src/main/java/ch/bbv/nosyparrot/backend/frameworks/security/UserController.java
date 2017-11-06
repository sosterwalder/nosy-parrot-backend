package ch.bbv.nosyparrot.backend.frameworks.security;

import ch.bbv.nosyparrot.backend.frameworks.security.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    private JpaUserEntityGateway jpaUserEntityGateway;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(
            JpaUserEntityGateway jpaUserEntityGateway,
            BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.jpaUserEntityGateway = jpaUserEntityGateway;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        String password = user.getPassword();
        String encodedPassword = this.bCryptPasswordEncoder.encode(password);
        user.setPassword(encodedPassword);

        this.jpaUserEntityGateway.save(user);
    }

}
