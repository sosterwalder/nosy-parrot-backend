package ch.bbv.nosyparrot.backend.interactors.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;


public class ListSurveysResponse implements SurveyResponse {
    private final List<Survey> surveyList;

    public ListSurveysResponse(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }
}
