package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.interfaces.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.core.entity.Survey;

import java.util.List;


public interface ListSurveysPresenterOutputPort {
    List<Survey> presentListOfSurveys(ListSurveysViewModel viewModel);
}
