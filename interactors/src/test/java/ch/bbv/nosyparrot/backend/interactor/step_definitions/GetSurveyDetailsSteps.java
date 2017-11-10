package ch.bbv.nosyparrot.backend.interactor.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyRequest;
import ch.bbv.nosyparrot.backend.interactors.output.GetSurveyDetailsResponse;
import ch.bbv.nosyparrot.backend.interactors.output.SurveyOutputPort;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
public class GetSurveyDetailsSteps implements En {
    private Survey expectedSurvey;
    private SurveyOutputPort surveyOutputPort;
    private SurveyEntityGateway surveyEntityGateway;

    public GetSurveyDetailsSteps() {
        When("^I have created survey called \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Long surveyId)
                -> this.expectedSurvey = new Survey(surveyId, surveyTitle));
        And("^I request to get the details of my survey \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Long surveyId) -> {
            this.surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);
            Mockito.when(this.surveyEntityGateway.getByIdentifier(surveyId)).thenReturn(this.expectedSurvey);

            SurveyRequest surveyRequest = new SurveyRequest();
            surveyRequest.setSurveyId(surveyId);

            this.surveyOutputPort = Mockito.mock(SurveyOutputPort.class);

            SurveyInteractor surveyInteractor = new SurveyInteractor(this.surveyOutputPort, this.surveyEntityGateway);
            surveyInteractor.getSurveyDetails(surveyRequest);
        });
        Then("^I should should receive the details of my survey \"([^\"]*)\" identified by (\\d+)$", (String expectedSurveyTitle, Long expectedSurveyId) -> {
            ArgumentCaptor<GetSurveyDetailsResponse> captor = ArgumentCaptor.forClass(GetSurveyDetailsResponse.class);
            Mockito.verify(this.surveyOutputPort, Mockito.times(1)).presentSurveyDetails(captor.capture());

            GetSurveyDetailsResponse getSurveyDetailsResponse = captor.getValue();
            Survey receivedSurvey = getSurveyDetailsResponse.getSurvey();

            assertThat(receivedSurvey.getId()).isEqualTo(expectedSurveyId);
            assertThat(receivedSurvey.getTitle()).isEqualTo(expectedSurveyTitle);
        });
    }
}
