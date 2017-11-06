package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysPresenterOutputPort;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysResponse;

import java.util.List;


public class ListSurveysPresenter implements ListSurveysOutputPort {
    // private final ListSurveysPresenterOutputPort listSurveysPresenterOutputPort;
    private ListSurveysViewModel listSurveysViewModel;

    /*
    public ListSurveysPresenter(ListSurveysPresenterOutputPort listSurveysPresenterOutputPort) {
        this.listSurveysPresenterOutputPort = listSurveysPresenterOutputPort;
    }
    */

    public void presentListOfSurveys(ListSurveysResponse listSurveysResponse) {
        List<Survey> surveyList = listSurveysResponse.getSurveyList();
        this.listSurveysViewModel = new ListSurveysViewModel(surveyList);
        // this.listSurveysPresenterOutputPort.presentListOfSurveys(listSurveysViewModel);
    }

    public ListSurveysViewModel getListSurveysViewModel() {
        return listSurveysViewModel;
    }
}
