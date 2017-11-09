package ch.bbv.nosyparrot.backend.interfaces.output;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysResponse;

import java.util.List;


public class CreateSurveysPresenter implements CreateSurveysOutputPort {
    private CreateSurveysViewModel createSurveysViewModel;

    @Override
    public void presentCreationOfSurvey(CreateSurveysResponse createSurveysResponse) {
        List<Survey> surveyList = createSurveysResponse.getSurveyList();
        this.createSurveysViewModel = new CreateSurveysViewModel(surveyList);
    }

    public CreateSurveysViewModel getCreateSurveysViewModel() {
        return createSurveysViewModel;
    }
}
