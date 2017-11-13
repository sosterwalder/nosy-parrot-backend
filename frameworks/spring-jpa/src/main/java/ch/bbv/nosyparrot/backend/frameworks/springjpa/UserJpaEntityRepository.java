package ch.bbv.nosyparrot.backend.frameworks.springjpa;

import ch.bbv.nosyparrot.backend.core.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaEntityRepository extends CrudRepository<UserJpaEntity, Long> {
    UserJpaEntity findByUsername(String username);
}
