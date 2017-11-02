package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.usecases.core.entity.SurveyEntityGateway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SurveyJpaEntityRepository extends CrudRepository<SurveyJpaEntity, String>, SurveyEntityGateway {
}
