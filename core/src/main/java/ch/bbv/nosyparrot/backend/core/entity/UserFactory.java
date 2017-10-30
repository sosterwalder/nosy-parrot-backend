package ch.bbv.nosyparrot.backend.core.entity;

public interface UserFactory {
    User createUser(String username, String password);
}
