package ch.bbv.nosyparrot.backend.configuration.security.entity;

import ch.bbv.nosyparrot.backend.usecases.core.entity.User;

public class UserFactory implements ch.bbv.nosyparrot.backend.usecases.core.entity.UserFactory{
    private UserFactory() {}

    @Override
    public User createUser(String username, String password) {
        return new ch.bbv.nosyparrot.backend.configuration.security.entity.User(username, password);
    }

    public static UserFactory create() {
        return new UserFactory();
    }
}
