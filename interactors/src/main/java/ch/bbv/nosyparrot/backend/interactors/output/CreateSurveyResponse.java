package ch.bbv.nosyparrot.backend.interactors.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public class CreateSurveyResponse implements SurveyResponse {
    private final List<Survey> surveyList;

    public CreateSurveyResponse(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }
}
