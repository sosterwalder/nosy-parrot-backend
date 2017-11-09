package ch.bbv.nosyparrot.backend.frameworks.springjpa;

import java.util.ArrayList;
import java.util.List;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.SurveyFactory;


public class SurveyJpaEntityGateway implements SurveyEntityGateway {
    private final SurveyJpaEntityRepository surveyJpaEntityRepository;

    public SurveyJpaEntityGateway(SurveyJpaEntityRepository surveyJpaEntityRepository) {
        this.surveyJpaEntityRepository = surveyJpaEntityRepository;
    }

    @Override
    public List<Survey> getAll() {
        List<Survey> surveyList = new ArrayList<>();
        surveyJpaEntityRepository.findAll().forEach(it -> surveyList.add(
                this.toDomain(it)
        ));

        return surveyList;
    }

    @Override
    public List<Survey> create(String title) {
        SurveyJpaEntity surveyJpaEntity = new SurveyJpaEntity(title);
        surveyJpaEntityRepository.save(surveyJpaEntity);

        // TODO: Fix this
        return this.getAll();
    }

    private Survey toDomain(SurveyJpaEntity entity) {
        return SurveyFactory.create().createSurvey(
                entity.getId(),
                entity.getTitle()
        );
    }
}
