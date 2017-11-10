package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

public class SurveyDetailsViewModel implements SurveyViewModel {
    private Survey survey;

    public SurveyDetailsViewModel(Survey survey) {
        this.survey = survey;
    }

    public Survey getSurvey() {
        return survey;
    }
}
