package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public class ListSurveysViewModel {
    private List<Survey> surveyList;


    public ListSurveysViewModel(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }
}
