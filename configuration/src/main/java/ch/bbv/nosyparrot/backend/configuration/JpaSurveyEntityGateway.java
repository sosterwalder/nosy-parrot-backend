package ch.bbv.nosyparrot.backend.configuration;

import java.util.ArrayList;
import java.util.List;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;


public class JpaSurveyEntityGateway implements SurveyEntityGateway {
    @Override
    public List<Survey> findAll() {
        List<Survey> surveyList = new ArrayList<>();
        // TODO
        // surveyJpaEntityRepository.findAll().forEach(it => surveys.add(toDomain(it)));

        return surveyList;
    }
}
