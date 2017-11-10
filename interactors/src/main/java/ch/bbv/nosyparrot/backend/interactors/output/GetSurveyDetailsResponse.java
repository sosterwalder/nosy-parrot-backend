package ch.bbv.nosyparrot.backend.interactors.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

public class GetSurveyDetailsResponse implements SurveyResponse {
    private final Survey survey;

    public GetSurveyDetailsResponse(Survey survey) {
        this.survey = survey;
    }

    public Survey getSurvey() {
        return survey;
    }
}
