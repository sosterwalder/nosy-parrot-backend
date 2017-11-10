package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.interactors.input.SurveyInputPort;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyRequest;

public class SurveyController {
    private final SurveyInputPort surveyInputPort;


    public SurveyController(SurveyInputPort surveyInputPort) {
        this.surveyInputPort = surveyInputPort;
    }

    public void createSurvey(String title) {
        SurveyRequest surveyRequest = new SurveyRequest();
        surveyRequest.setSurveyTitle(title);
        surveyInputPort.createSurvey(surveyRequest);
    }

    public void getSurveys() {
        SurveyRequest surveyRequest = new SurveyRequest();
        this.surveyInputPort.listSurveys(surveyRequest);
    }
}
