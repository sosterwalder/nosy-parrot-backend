package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysPresenterOutputPort;
import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public class ListSurveysView implements ListSurveysPresenterOutputPort {
    private List<Survey> surveyList;

    @Override
    public void presentListOfSurveys(ListSurveysViewModel viewModel) {
        this.surveyList = viewModel.getSurveyList();
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }
}
