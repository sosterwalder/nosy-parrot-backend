package ch.bbv.nosyparrot.backend.core.entity;


public interface User {
    long getId();
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
}
