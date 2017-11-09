package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.SurveyFactory;

import java.util.ArrayList;
import java.util.List;

public class SurveyService implements SurveyEntityGateway {
    private static SurveyDao surveyDao;

    public SurveyService() {
        this.surveyDao = new SurveyDao();
    }

    @Override
    public List<Survey> getAll() {
        List<Survey> surveyList = new ArrayList<>();

        this.surveyDao.openCurrentSession();
        this.surveyDao.findAll().forEach(surveyJpaEntity -> surveyList.add(
                this.surveyJpaEntityToDomain(surveyJpaEntity)
        ));
        this.surveyDao.closeCurrentSession();

        return surveyList;
    }

    @Override
    public List<Survey> create(String title) {
        SurveyJpaEntity surveyJpaEntity = new SurveyJpaEntity(title);

        surveyDao.openCurrentSession();
        surveyDao.persist(surveyJpaEntity);
        surveyDao.closeCurrentSession();

        // TODO: Fix this
        return this.getAll();
    }

    private Survey surveyJpaEntityToDomain(SurveyJpaEntity entity) {
        return SurveyFactory.create().createSurvey(
                entity.getId(),
                entity.getTitle()
        );
    }
}
