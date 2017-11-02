package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysRequest;

public class ListSurveysController {
    private final ListSurveysInputPort listSurveysInputPort;

    public ListSurveysController(ListSurveysInputPort listSurveysInputPort) {
        this.listSurveysInputPort = listSurveysInputPort;
    }

    public void getSurveysForUserId(long userId) {
        ListSurveysRequest listSurveysRequest = new ListSurveysRequest(userId);
        listSurveysInputPort.listSurveys(listSurveysRequest);
    }


}
