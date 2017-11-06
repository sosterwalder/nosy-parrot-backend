package ch.bbv.nosyparrot.backend.frameworks;

import java.util.ArrayList;
import java.util.List;

import ch.bbv.nosyparrot.backend.frameworks.security.entity.UserFactory;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.SurveyFactory;
import ch.bbv.nosyparrot.backend.core.entity.User;


public class SurveyJpaEntityGateway implements SurveyEntityGateway {
    private final SurveyJpaEntityRepository surveyJpaEntityRepository;

    public SurveyJpaEntityGateway(SurveyJpaEntityRepository surveyJpaEntityRepository) {
        this.surveyJpaEntityRepository = surveyJpaEntityRepository;
    }

    @Override
    public List<Survey> findByUser(long userId) {
        List<Survey> surveyList = new ArrayList<>();
        surveyJpaEntityRepository.findByUserId(userId).forEach(it -> surveyList.add(
                this.toDomain(it)
        ));

        return surveyList;
    }

    private Survey toDomain(SurveyJpaEntity entity) {
        return SurveyFactory.create().createSurvey(
                entity.getId(),
                entity.getTitle(),
                toDomain(entity.getUser())
        );
    }

    private User toDomain(ch.bbv.nosyparrot.backend.frameworks.security.entity.User entity) {
        return UserFactory.create().createUser(
                entity.getUsername(),
                entity.getPassword()
        );
    }
}
