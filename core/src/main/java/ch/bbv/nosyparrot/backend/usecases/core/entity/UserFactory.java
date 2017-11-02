package ch.bbv.nosyparrot.backend.usecases.core.entity;

public interface UserFactory {
    User createUser(String username, String password);
}
