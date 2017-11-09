package ch.bbv.nosyparrot.backend.interfaces.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interfaces.CreateSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.output.CreateSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.output.CreateSurveysViewModel;
import ch.bbv.nosyparrot.backend.usecases.input.CreateSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysResponse;
import cucumber.api.java8.En;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


public class CreateSurveysSteps implements En {
    private CreateSurveysResponse createSurveysResponse;
    private static long surveyId = 123L;
    private static String surveyTitle = "surveyTitle";

    public CreateSurveysSteps() {
        Given("^I am a logged-in User$", () -> {
            // TODO: Mock user
        });
        When("^I create a new survey with a title but without questions$", () -> {
            CreateSurveysInputPort createSurveysInputPort = Mockito.mock(CreateSurveysInputPort.class);
            CreateSurveysController createSurveysController = new CreateSurveysController(createSurveysInputPort);

            this.createSurveysResponse = Mockito.mock(CreateSurveysResponse.class);
            Survey expectedSurvey = new Survey(CreateSurveysSteps.surveyId, CreateSurveysSteps.surveyTitle);
            List<Survey> expectedSurveyList = new ArrayList<>();
            expectedSurveyList.add(expectedSurvey);
            when(this.createSurveysResponse.getSurveyList()).thenReturn(expectedSurveyList);

            createSurveysController.createSurvey(CreateSurveysSteps.surveyTitle);
        });
        Then("^the survey should appear in my list of surveys$", () -> {
            CreateSurveysPresenter createSurveysPresenter = new CreateSurveysPresenter();
            createSurveysPresenter.presentCreationOfSurvey(this.createSurveysResponse);

            CreateSurveysViewModel receivedSurveysViewModel = createSurveysPresenter.getCreateSurveysViewModel();
            List<Survey> receivedSurveys = receivedSurveysViewModel.getSurveyList();
            assertThat(receivedSurveys).extracting("title").contains(CreateSurveysSteps.surveyTitle);
        });
    }
}
