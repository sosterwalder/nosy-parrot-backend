package ch.bbv.nosyparrot.backend.interactors;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyInputPort;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyRequest;
import ch.bbv.nosyparrot.backend.interactors.output.*;

import java.util.List;

@SuppressWarnings("unused")
public class SurveyInteractor implements SurveyInputPort {
    private final SurveyOutputPort surveyOutputPort;
    private final SurveyEntityGateway surveyEntityGateway;

    public SurveyInteractor(SurveyOutputPort surveyOutputPort, SurveyEntityGateway surveyEntityGateway) {
        this.surveyOutputPort = surveyOutputPort;
        this.surveyEntityGateway = surveyEntityGateway;
    }

    @Override
    public void createSurvey(SurveyRequest surveyRequest) {
        // Extract request parameters
        String title = surveyRequest.getSurveyTitle();

        // Create survey through gateway
        List<Survey> surveyList = this.surveyEntityGateway.create(title);

        // Create response
        CreateSurveyResponse surveyResponse = new CreateSurveyResponse(surveyList);

        // Pass response to the output port
        this.surveyOutputPort.presentCreationOfSurvey(surveyResponse);
    }

    @Override
    public void getSurveyDetails(SurveyRequest surveyRequest) {
        long surveyId = surveyRequest.getSurveyId();
        Survey survey = this.surveyEntityGateway.getByIdentifier(surveyId);
        GetSurveyDetailsResponse surveyResponse = new GetSurveyDetailsResponse(survey);
        this.surveyOutputPort.presentSurveyDetails(surveyResponse);

    }

    @Override
    public void listSurveys(SurveyRequest surveysRequest) {
        // TODO: Extract data from request

        // Pass the needed data from the request model to the entity gateway
        // and receive the result.
        List<Survey> surveyList = this.surveyEntityGateway.getAll();

        // Create a response model from the received result.
        ListSurveysResponse surveyResponse = new ListSurveysResponse(surveyList);

        // Pass the response model to the boundary.
        this.surveyOutputPort.presentListOfSurveys(surveyResponse);

    }
}
