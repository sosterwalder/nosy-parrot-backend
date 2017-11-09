package ch.bbv.nosyparrot.backend.usecases.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public class CreateSurveysResponse {
    private final List<Survey> surveyList;

    public CreateSurveysResponse(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }
}
