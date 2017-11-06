package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysPresenterOutputPort;
import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;

public class ListSurveysView implements ListSurveysPresenterOutputPort {
    @Override
    public List<Survey> presentListOfSurveys(ListSurveysViewModel viewModel) {
        return viewModel.getSurveyList();
    }
}
