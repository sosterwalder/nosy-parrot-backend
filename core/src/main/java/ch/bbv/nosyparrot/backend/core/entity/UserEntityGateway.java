package ch.bbv.nosyparrot.backend.core.entity;

public interface UserEntityGateway {
    User create(String username, String password);
    User findByUsername(String username);
}
