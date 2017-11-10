package ch.bbv.nosyparrot.backend.usecases;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.input.GetSurveyDetailsInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.GetSurveyDetailsRequest;
import ch.bbv.nosyparrot.backend.usecases.output.GetSurveyDetailsOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.GetSurveyDetailsResponse;

public class GetSurveyDetailsUseCase implements GetSurveyDetailsInputPort {
    private final GetSurveyDetailsOutputPort getSurveyDetailsOutputPort;
    private final SurveyEntityGateway surveyEntityGateway;

    public GetSurveyDetailsUseCase(GetSurveyDetailsOutputPort getSurveyDetailsOutputPort, SurveyEntityGateway surveyEntityGateway) {
        this.getSurveyDetailsOutputPort = getSurveyDetailsOutputPort;
        this.surveyEntityGateway = surveyEntityGateway;
    }


    @Override
    public void getSurveyDetails(GetSurveyDetailsRequest getSurveyDetailsRequest) {
        long surveyId = getSurveyDetailsRequest.getSurveyId();

        Survey survey = this.surveyEntityGateway.getByIdentifier(surveyId);

        GetSurveyDetailsResponse getSurveyDetailsResponse = new GetSurveyDetailsResponse(survey);

        this.getSurveyDetailsOutputPort.presentSurveyDetails(getSurveyDetailsResponse);
    }
}
