package ch.bbv.nosyparrot.backend.interactors.output;

import ch.bbv.nosyparrot.backend.core.entity.User;

public class SignUpUserResponse {
    private User user;

    public SignUpUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
