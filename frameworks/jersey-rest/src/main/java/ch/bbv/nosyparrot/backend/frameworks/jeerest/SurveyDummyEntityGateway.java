package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;

import java.util.ArrayList;
import java.util.List;

public class SurveyDummyEntityGateway implements SurveyEntityGateway {
    @Override
    public List<Survey> getAll() {
        return new ArrayList<>();
    }
}
