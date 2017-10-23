package ch.bbv.nosyparrot.backend.core.usecase.input;

import java.util.List;
import ch.bbv.nosyparrot.backend.core.entity.Survey;


public interface SurveyService {
    List<Survey> getSurveys();
}
