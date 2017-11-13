package ch.bbv.nosyparrot.backend.frameworks.springjpa;

import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.core.entity.UserEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.UserFactory;

public class UserJpaEntityGateway implements UserEntityGateway {
    private final UserJpaEntityRepository userJpaEntityRepository;

    public UserJpaEntityGateway(UserJpaEntityRepository userJpaEntityRepository) {
        this.userJpaEntityRepository = userJpaEntityRepository;
    }

    @Override
    public User create(String username, String password) {
        UserJpaEntity entity = new UserJpaEntity(username, password);
        this.userJpaEntityRepository.save(entity);

        return this.userJpaEntityToDomain(entity);
    }

    @Override
    public User findByUsername(String username) {
        UserJpaEntity entity = this.userJpaEntityRepository.findByUsername(username);

        return this.userJpaEntityToDomain(entity);
    }

    private User userJpaEntityToDomain(UserJpaEntity user) {
        return UserFactory.create().createUser(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

}
