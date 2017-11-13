package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.frameworks.hibernatejpa.UserService;
import ch.bbv.nosyparrot.backend.interactors.UserInteractor;
import ch.bbv.nosyparrot.backend.interfaces.UserController;
import ch.bbv.nosyparrot.backend.interfaces.output.SignUpUserViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.UserPresenter;
import org.mindrot.jbcrypt.BCrypt;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/users")
public class UserRestService {
    private final UserPresenter userPresenter;
    private final UserController userController;

    public UserRestService() {
        final UserService userService = new UserService();
        this.userPresenter = new UserPresenter();
        UserInteractor userInteractor = new UserInteractor(this.userPresenter, userService);
        this.userController = new UserController(userInteractor);
    }

    @POST
    @Path("/sign-up")
    @Produces(MediaType.APPLICATION_JSON)
    public User signUp(String username, String password) {
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.userController.signUp(username, encryptedPassword);

        SignUpUserViewModel signUpUserViewModel = (SignUpUserViewModel) this.userPresenter.getUserViewModel();

        return signUpUserViewModel.getUser();
    }
}
