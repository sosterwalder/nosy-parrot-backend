package ch.bbv.nosyparrot.backend.frameworks.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SurveyJpaEntityRepository extends CrudRepository<SurveyJpaEntity, Long> {
}
