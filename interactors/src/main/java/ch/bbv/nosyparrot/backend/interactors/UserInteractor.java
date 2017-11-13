package ch.bbv.nosyparrot.backend.interactors;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.core.entity.UserEntityGateway;
import ch.bbv.nosyparrot.backend.interactors.input.UserInputPort;
import ch.bbv.nosyparrot.backend.interactors.input.UserRequest;
import ch.bbv.nosyparrot.backend.interactors.output.SignUpUserResponse;
import ch.bbv.nosyparrot.backend.interactors.output.UserOutputPort;

@SuppressWarnings("unused")
public class UserInteractor implements UserInputPort {
    private final UserOutputPort userOutputPort;
    private final UserEntityGateway userEntityGateway;

    public UserInteractor(
            UserOutputPort userOutputPort,
            UserEntityGateway userEntityGateway
    ) {
        this.userOutputPort = userOutputPort;
        this.userEntityGateway = userEntityGateway;
    }

    @Override
    public void signUp(UserRequest userRequest) {
        String username = userRequest.getUsername();
        String password = userRequest.getPassword();

        User user = this.userEntityGateway.create(username, password);

        SignUpUserResponse signUpUserResponse = new SignUpUserResponse(user);
        this.userOutputPort.presentSignUpOfUser(signUpUserResponse);
    }
}
