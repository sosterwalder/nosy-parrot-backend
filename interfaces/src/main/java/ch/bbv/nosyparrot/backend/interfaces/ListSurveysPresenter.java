package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysPresenterOutputPort;
import ch.bbv.nosyparrot.backend.usecases.core.entity.Survey;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysResponse;

import java.util.List;


public class ListSurveysPresenter implements ListSurveysOutputPort {
    private final ListSurveysPresenterOutputPort listSurveysPresenterOutputPort;

    public ListSurveysPresenter(ListSurveysPresenterOutputPort listSurveysPresenterOutputPort) {
        this.listSurveysPresenterOutputPort = listSurveysPresenterOutputPort;
    }

    @Override
    public void presentListOfSurveys(ListSurveysResponse listSurveysResponse) {
        List<Survey> surveyList = listSurveysResponse.getSurveyList();
        ListSurveysViewModel listSurveysViewModel = new ListSurveysViewModel(surveyList);
        this.listSurveysPresenterOutputPort.presentListOfSurveys(listSurveysViewModel);
    }
}
