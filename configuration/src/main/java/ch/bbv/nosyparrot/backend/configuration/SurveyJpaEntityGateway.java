package ch.bbv.nosyparrot.backend.configuration;

import java.util.ArrayList;
import java.util.List;

import ch.bbv.nosyparrot.backend.configuration.security.entity.UserFactory;
import ch.bbv.nosyparrot.backend.usecases.core.entity.Survey;
import ch.bbv.nosyparrot.backend.usecases.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.core.entity.SurveyFactory;
import ch.bbv.nosyparrot.backend.usecases.core.entity.User;


public class SurveyJpaEntityGateway implements SurveyEntityGateway {
    private final SurveyJpaEntityRepository surveyJpaEntityRepository;

    public SurveyJpaEntityGateway(SurveyJpaEntityRepository surveyJpaEntityRepository) {
        this.surveyJpaEntityRepository = surveyJpaEntityRepository;
    }

    @Override
    public List<Survey> findAll() {
        List<Survey> surveyList = new ArrayList<>();
        surveyJpaEntityRepository.findAll().forEach(it -> surveyList.add(toDomain(it)));

        return surveyList;
    }

    private Survey toDomain(SurveyJpaEntity entity) {
        return SurveyFactory.create().createSurvey(
                entity.getId(),
                entity.getTitle(),
                toDomain(entity.getUser())
        );
    }

    private User toDomain(ch.bbv.nosyparrot.backend.configuration.security.entity.User entity) {
        return UserFactory.create().createUser(
                entity.getUsername(),
                entity.getPassword()
        );
    }
}
