package ch.bbv.nosyparrot.backend.interactors.input;

public interface SurveyInputPort {
    void createSurvey(SurveyRequest surveyRequest);
    void getSurveyDetails(SurveyRequest surveyRequest);
    void listSurveys(SurveyRequest surveysRequest);
}
