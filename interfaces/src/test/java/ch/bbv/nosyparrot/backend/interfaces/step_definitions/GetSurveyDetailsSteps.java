package ch.bbv.nosyparrot.backend.interfaces.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyInputPort;
import ch.bbv.nosyparrot.backend.interactors.output.GetSurveyDetailsResponse;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyDetailsViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
public class GetSurveyDetailsSteps implements En {
    private Survey expectedSurvey;
    public GetSurveyDetailsSteps() {
        When("^I have created survey called \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Long surveyId) -> {
            this.expectedSurvey = new Survey(surveyId, surveyTitle);
        });

        When("^I request to get the details of my survey \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Long surveyId) -> {
            SurveyInputPort surveyInputPort = Mockito.mock(SurveyInputPort.class);
            SurveyController surveyController = new SurveyController(surveyInputPort);
            surveyController.getSurveyDetails(surveyId);
        });

        Then("^I should should receive the details of my survey \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Integer surveyId) -> {
            SurveyPresenter surveyPresenter = new SurveyPresenter();

            GetSurveyDetailsResponse getSurveyDetailsResponse = Mockito.mock(GetSurveyDetailsResponse.class);
            Mockito.when(getSurveyDetailsResponse.getSurvey()).thenReturn(this.expectedSurvey);

            surveyPresenter.presentSurveyDetails(getSurveyDetailsResponse);

            ArgumentCaptor<SurveyDetailsViewModel> surveyDetailsViewModelArgumentCaptor = ArgumentCaptor.forClass(SurveyDetailsViewModel.class);
            SurveyDetailsViewModel receivedSurveysViewModel = (SurveyDetailsViewModel) surveyPresenter.getSurveyViewModel();
            Survey receivedSurvey = receivedSurveysViewModel.getSurvey();

            assertThat(receivedSurvey.getId()).isEqualTo(this.expectedSurvey.getId());
            assertThat(receivedSurvey.getTitle()).isEqualTo(this.expectedSurvey.getTitle());
        });
    }
}
