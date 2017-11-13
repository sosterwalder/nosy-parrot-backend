package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.SurveyFactory;

import java.util.ArrayList;
import java.util.List;

public class SurveyService implements SurveyEntityGateway {
    private static SurveyDao surveyDao;

    public SurveyService() {
        surveyDao = new SurveyDao();
    }

    @Override
    public List<Survey> getAll() {
        List<Survey> surveyList = new ArrayList<>();

        surveyDao.findAll().forEach(surveyJpaEntity -> surveyList.add(
                this.surveyJpaEntityToDomain(surveyJpaEntity)
        ));

        return surveyList;
    }

    @Override
    public List<Survey> create(String title) {
        SurveyJpaEntity surveyJpaEntity = new SurveyJpaEntity();
        surveyJpaEntity.setTitle(title);
        surveyDao.save(surveyJpaEntity);

        // TODO: Fix this
        return this.getAll();
    }

    @Override
    public Survey getByIdentifier(long surveyIdentifier) {
        SurveyJpaEntity surveyJpaEntity = surveyDao.findById(surveyIdentifier);

        return this.surveyJpaEntityToDomain(surveyJpaEntity);
    }

    private Survey surveyJpaEntityToDomain(SurveyJpaEntity entity) {
        return SurveyFactory.create().createSurvey(
                entity.getId(),
                entity.getTitle()
        );
    }
}
