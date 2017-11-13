package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.interfaces.UserController;
import ch.bbv.nosyparrot.backend.interfaces.output.SignUpUserViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.UserPresenter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static ch.bbv.nosyparrot.backend.frameworks.springrest.SecurityConstants.SIGN_UP_URL;


@RestController
public class UserRestController {
    private final UserController userController;
    private final UserPresenter userPresenter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRestController(UserController userController, UserPresenter userPresenter) {
        this.userController = userController;
        this.userPresenter = userPresenter;

        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @SuppressWarnings("unused")
    @PostMapping(value = SIGN_UP_URL)
    public User signUp(@RequestBody User user) {
        String encodedPassword = this.bCryptPasswordEncoder.encode(user.getPassword());
        this.userController.signUp(user.getUsername(), encodedPassword);
        SignUpUserViewModel viewModel = (SignUpUserViewModel) this.userPresenter.getUserViewModel();

        return viewModel.getUser();
    }
}
