package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.interactors.output.SignUpUserResponse;
import ch.bbv.nosyparrot.backend.interactors.output.UserOutputPort;

public class UserPresenter implements UserOutputPort {
    private UserViewModel userViewModel;

    @Override
    public void presentSignUpOfUser(SignUpUserResponse signUpUserResponse) {
        User user = signUpUserResponse.getUser();
        this.userViewModel = new SignUpUserViewModel(user);
    }

    public UserViewModel getUserViewModel() {
        return this.userViewModel;
    }
}
