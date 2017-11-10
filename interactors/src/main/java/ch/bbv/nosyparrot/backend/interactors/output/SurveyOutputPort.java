package ch.bbv.nosyparrot.backend.interactors.output;

public interface SurveyOutputPort {
    void presentCreationOfSurvey(CreateSurveyResponse surveyResponse);
    void presentListOfSurveys(ListSurveysResponse surveyResponse);
    void presentSurveyDetails(GetSurveyDetailsResponse surveyResponse);
}
