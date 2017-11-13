package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.core.entity.User;

public class SignUpUserViewModel implements UserViewModel {
    private final User user;

    SignUpUserViewModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
