package ch.bbv.nosyparrot.backend.usecases;

import ch.bbv.nosyparrot.backend.usecases.core.entity.Survey;
import ch.bbv.nosyparrot.backend.usecases.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysRequest;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysResponse;

import java.util.List;


public class ListSurveysUseCase implements ListSurveysInputPort {
    private final ListSurveysOutputPort listSurveysOutputPort;
    private final SurveyEntityGateway surveyEntityGateway;

    public ListSurveysUseCase(ListSurveysOutputPort listSurveysOutputPort, SurveyEntityGateway surveyEntityGateway) {
        this.listSurveysOutputPort = listSurveysOutputPort;
        this.surveyEntityGateway = surveyEntityGateway;
    }

    @Override
    public void listSurveys(ListSurveysRequest listSurveysRequest) {
        // Extract data from the request model.
        final long userId = listSurveysRequest.getUserId();

        // Pass the needed data from the request model to the entity gateway
        // and receive the result.
        List<Survey> surveyList = this.surveyEntityGateway.findByUser(userId);

        // Create a response model from the received result.
        ListSurveysResponse listSurveysResponse = new ListSurveysResponse(surveyList);

        // Pass the response model to the boundary.
        listSurveysOutputPort.presentListOfSurveys(listSurveysResponse);

    }
}
