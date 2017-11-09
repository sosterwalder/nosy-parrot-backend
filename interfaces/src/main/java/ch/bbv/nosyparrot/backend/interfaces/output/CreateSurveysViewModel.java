package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public class CreateSurveysViewModel {
    private List<Survey> surveyList;

    public CreateSurveysViewModel(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }
}
