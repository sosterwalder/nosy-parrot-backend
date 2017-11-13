package ch.bbv.nosyparrot.backend.interactor.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.core.entity.UserEntityGateway;
import ch.bbv.nosyparrot.backend.interactors.UserInteractor;
import ch.bbv.nosyparrot.backend.interactors.input.UserRequest;
import ch.bbv.nosyparrot.backend.interactors.output.SignUpUserResponse;
import ch.bbv.nosyparrot.backend.interactors.output.UserOutputPort;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
public class RegisterAsUserSteps implements En {
    private UserOutputPort userOutputPort;

    public RegisterAsUserSteps() {
        When("^I register myself as user \"([^\"]*)\" with the password \"([^\"]*)\"$", (String username, String password) -> {
            this.userOutputPort = Mockito.mock(UserOutputPort.class);
            UserEntityGateway userEntityGateway = Mockito.mock(UserEntityGateway.class);

            User expectedUser = new User(username, password);
            Mockito.when(userEntityGateway.create(username, password)).thenReturn(expectedUser);

            UserRequest userRequest = new UserRequest();
            userRequest.setUsername(username);
            userRequest.setPassword(password);

            UserInteractor userInteractor = new UserInteractor(this.userOutputPort, userEntityGateway);
            userInteractor.signUp(userRequest);
        });
        Then("^I am registered within the system as user \"([^\"]*)\"$", (String expectedUsername) -> {
            ArgumentCaptor<SignUpUserResponse> signUpUserResponseArgumentCaptor = ArgumentCaptor.forClass(SignUpUserResponse.class);
            Mockito.verify(this.userOutputPort, Mockito.times(1)).presentSignUpOfUser(signUpUserResponseArgumentCaptor.capture());
            SignUpUserResponse signUpUserResponse = signUpUserResponseArgumentCaptor.getValue();

            User receivedUser = signUpUserResponse.getUser();
            assertThat(receivedUser.getUsername()).isEqualTo(expectedUsername);
        });
    }

}
