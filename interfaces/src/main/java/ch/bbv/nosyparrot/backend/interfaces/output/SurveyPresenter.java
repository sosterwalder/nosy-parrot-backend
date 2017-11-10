package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interactors.output.CreateSurveyResponse;
import ch.bbv.nosyparrot.backend.interactors.output.GetSurveyDetailsResponse;
import ch.bbv.nosyparrot.backend.interactors.output.ListSurveysResponse;
import ch.bbv.nosyparrot.backend.interactors.output.SurveyOutputPort;

import java.util.List;


public class SurveyPresenter implements SurveyOutputPort {
    private SurveyViewModel surveyViewModel;

    @Override
    public void presentCreationOfSurvey(CreateSurveyResponse surveyResponse) {
        List<Survey> surveyList = surveyResponse.getSurveyList();
        this.surveyViewModel = new ListSurveysViewModel(surveyList);
    }

    @Override
    public void presentListOfSurveys(ListSurveysResponse surveyResponse) {
        List<Survey> surveyList = surveyResponse.getSurveyList();
        this.surveyViewModel = new ListSurveysViewModel(surveyList);
    }

    @Override
    public void presentSurveyDetails(GetSurveyDetailsResponse surveyResponse) {
        Survey survey = surveyResponse.getSurvey();
        this.surveyViewModel = new SurveyDetailsViewModel(survey);

    }

    public SurveyViewModel getSurveyViewModel() {
        return surveyViewModel;
    }
}
