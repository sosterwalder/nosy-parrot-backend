package ch.bbv.nosyparrot.backend.interfaces.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyInputPort;
import ch.bbv.nosyparrot.backend.interactors.output.CreateSurveyResponse;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import cucumber.api.java8.En;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SuppressWarnings("unused")
public class CreateSurveysSteps implements En {
    private CreateSurveyResponse createSurveysResponse;
    private static long surveyId = 123L;
    private static String surveyTitle = "surveyTitle";

    public CreateSurveysSteps() {
        Given("^I am a logged-in User$", () -> {
            // TODO: Mock user
        });
        When("^I create a new survey with a title but without questions$", () -> {
            SurveyInputPort surveyInputPort = Mockito.mock(SurveyInputPort.class);
            SurveyController surveyController = new SurveyController(surveyInputPort);

            this.createSurveysResponse = Mockito.mock(CreateSurveyResponse.class);
            Survey expectedSurvey = new Survey(CreateSurveysSteps.surveyId, CreateSurveysSteps.surveyTitle);
            List<Survey> expectedSurveyList = new ArrayList<>();
            expectedSurveyList.add(expectedSurvey);
            when(this.createSurveysResponse.getSurveyList()).thenReturn(expectedSurveyList);

            surveyController.createSurvey(CreateSurveysSteps.surveyTitle);
        });
        Then("^the survey should appear in my list of surveys$", () -> {
            SurveyPresenter surveyPresenter = new SurveyPresenter();
            surveyPresenter.presentCreationOfSurvey(this.createSurveysResponse);

            ListSurveysViewModel viewModel = (ListSurveysViewModel) surveyPresenter.getSurveyViewModel();
            List<Survey> receivedSurveys = viewModel.getSurveyList();
            assertThat(receivedSurveys).extracting("title").contains(CreateSurveysSteps.surveyTitle);
        });
    }
}
