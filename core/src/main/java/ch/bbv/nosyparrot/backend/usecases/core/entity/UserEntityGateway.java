package ch.bbv.nosyparrot.backend.usecases.core.entity;

public interface UserEntityGateway {
    User findByUsername(String username);
}
