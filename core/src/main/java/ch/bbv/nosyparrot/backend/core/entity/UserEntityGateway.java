package ch.bbv.nosyparrot.backend.core.entity;

public interface UserEntityGateway {
    User findByUsername(String username);
}
