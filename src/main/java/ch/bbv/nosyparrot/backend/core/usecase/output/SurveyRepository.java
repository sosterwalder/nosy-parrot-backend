package ch.bbv.nosyparrot.backend.core.usecase.output;


import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public interface SurveyRepository {

    List<Survey> getSurveys();
}
