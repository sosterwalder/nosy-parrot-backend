package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysRequest;

public class ListSurveysController {
    private final ListSurveysInputPort listSurveysInputPort;

    public ListSurveysController(ListSurveysInputPort listSurveysInputPort) {
        this.listSurveysInputPort = listSurveysInputPort;
    }

    public void getSurveys() {
        ListSurveysRequest listSurveysRequest = new ListSurveysRequest();
        listSurveysInputPort.listSurveys(listSurveysRequest);
    }
}
