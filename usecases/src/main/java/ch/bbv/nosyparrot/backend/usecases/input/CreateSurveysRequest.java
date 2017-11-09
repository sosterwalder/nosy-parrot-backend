package ch.bbv.nosyparrot.backend.usecases.input;

public class CreateSurveysRequest {
    private String surveyTitle;

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }
}
