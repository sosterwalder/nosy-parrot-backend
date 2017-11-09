package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.usecases.input.CreateSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.CreateSurveysRequest;

public class CreateSurveysController {
    private final CreateSurveysInputPort createSurveysInputPort;

    public CreateSurveysController(CreateSurveysInputPort createSurveysInputPort) {
        this.createSurveysInputPort = createSurveysInputPort;
    }

    public void createSurvey(String title) {
        CreateSurveysRequest createSurveysRequest = new CreateSurveysRequest();
        createSurveysRequest.setSurveyTitle(title);
        createSurveysInputPort.createSurvey(createSurveysRequest);
    }
}
