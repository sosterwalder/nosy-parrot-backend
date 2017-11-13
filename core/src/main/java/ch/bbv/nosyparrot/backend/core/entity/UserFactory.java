package ch.bbv.nosyparrot.backend.core.entity;

public class UserFactory {
    private UserFactory() {}

    public User createUser(long id, String username, String password) {
        User user = new User(username, password);
        user.setId(id);

        return user;
    }

    public static UserFactory create() {
        return new UserFactory();
    }
}
