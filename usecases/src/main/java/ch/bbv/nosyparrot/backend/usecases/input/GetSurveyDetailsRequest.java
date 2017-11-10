package ch.bbv.nosyparrot.backend.usecases.input;

public class GetSurveyDetailsRequest {
    private Long surveyId;

    public GetSurveyDetailsRequest(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
}
