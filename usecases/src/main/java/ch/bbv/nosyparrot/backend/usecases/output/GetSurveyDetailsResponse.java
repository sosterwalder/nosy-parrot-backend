package ch.bbv.nosyparrot.backend.usecases.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

public class GetSurveyDetailsResponse {
    private final Survey survey;

    public GetSurveyDetailsResponse(Survey survey) {
        this.survey = survey;
    }

    public Survey getSurvey() {
        return survey;
    }
}
