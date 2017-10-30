package ch.bbv.nosyparrot.backend.configuration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SurveyJpaEntityRepository extends CrudRepository<SurveyJpaEntity, String> {
}
