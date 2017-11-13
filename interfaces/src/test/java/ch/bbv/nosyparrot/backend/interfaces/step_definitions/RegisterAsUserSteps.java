package ch.bbv.nosyparrot.backend.interfaces.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.interactors.input.UserInputPort;
import ch.bbv.nosyparrot.backend.interactors.output.SignUpUserResponse;
import ch.bbv.nosyparrot.backend.interfaces.UserController;
import ch.bbv.nosyparrot.backend.interfaces.output.SignUpUserViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.UserPresenter;
import cucumber.api.java8.En;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
public class RegisterAsUserSteps implements En {
    private SignUpUserResponse signUpUserResponse;

    public RegisterAsUserSteps() {
        When("^I register myself as user \"([^\"]*)\" with the password \"([^\"]*)\"$", (String username, String password) -> {
            UserInputPort userInputPort = Mockito.mock(UserInputPort.class);
            UserController userController = new UserController(userInputPort);

            this.signUpUserResponse = Mockito.mock(SignUpUserResponse.class);

            User expectedUser = new User(username, password);
            Mockito.when(this.signUpUserResponse.getUser()).thenReturn(expectedUser);

            userController.signUp(username, password);
        });
        Then("^I am registered within the system as user \"([^\"]*)\"$", (String expectedUsername) -> {
            UserPresenter userPresenter = new UserPresenter();
            userPresenter.presentSignUpOfUser(this.signUpUserResponse);

            SignUpUserViewModel viewModel = (SignUpUserViewModel) userPresenter.getUserViewModel();
            User receivedUser = viewModel.getUser();

            assertThat(receivedUser.getUsername()).isEqualTo(expectedUsername);
        });
    }
}
