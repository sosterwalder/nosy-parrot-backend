package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.core.entity.UserEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.UserFactory;

public class UserService implements UserEntityGateway {
    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    @Override
    public User create(String username, String password) {
        UserJpaEntity userJpaEntity = new UserJpaEntity(username, password);
        userDao.save(userJpaEntity);

        return this.userJpaEntityToDomain(userJpaEntity);
    }

    @Override
    public User findByUsername(String username) {
        // TODO: Implement me
        return null;
    }

    private User userJpaEntityToDomain(UserJpaEntity entity) {
        return UserFactory.create().createUser(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword()
        );
    }
}
