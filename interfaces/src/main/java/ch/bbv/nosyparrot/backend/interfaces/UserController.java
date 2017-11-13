package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.interactors.input.UserInputPort;
import ch.bbv.nosyparrot.backend.interactors.input.UserRequest;

public class UserController {
    private final UserInputPort userInputPort;

    public UserController(UserInputPort userInputPort) {
        this.userInputPort = userInputPort;
    }

    public void signUp(String username, String password) {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(username);
        userRequest.setPassword(password);

        this.userInputPort.signUp(userRequest);
    }
}
