package ch.bbv.nosyparrot.backend.frameworks;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SurveyJpaEntityRepository extends CrudRepository<SurveyJpaEntity, String> {
    public List<SurveyJpaEntity> findByUserId(long userId);
}
