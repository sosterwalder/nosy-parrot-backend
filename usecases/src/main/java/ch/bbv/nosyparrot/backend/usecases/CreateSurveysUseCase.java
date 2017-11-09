package ch.bbv.nosyparrot.backend.usecases;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.input.CreateSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.CreateSurveysRequest;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysResponse;

import java.util.List;

public class CreateSurveysUseCase implements CreateSurveysInputPort {
    private final CreateSurveysOutputPort createSurveysOutputPort;
    private final SurveyEntityGateway surveyEntityGateway;

    public CreateSurveysUseCase(CreateSurveysOutputPort createSurveysOutputPort, SurveyEntityGateway surveyEntityGateway) {
        this.createSurveysOutputPort = createSurveysOutputPort;
        this.surveyEntityGateway = surveyEntityGateway;
    }

    public CreateSurveysOutputPort getCreateSurveysOutputPort() {
        return createSurveysOutputPort;
    }

    @Override
    public void createSurvey(CreateSurveysRequest createSurveyRequest) {
        // Extract request parameters
        String title = createSurveyRequest.getSurveyTitle();

        // Create survey through gateway
        List<Survey> surveyList = this.surveyEntityGateway.create(title);

        // Create response
        CreateSurveysResponse createSurveyResponse = new CreateSurveysResponse(surveyList);

        // Pass response to the output port
        this.createSurveysOutputPort.presentCreationOfSurvey(createSurveyResponse);
    }
}
