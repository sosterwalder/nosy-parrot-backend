package ch.bbv.nosyparrot.backend.usecases.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.GetSurveyDetailsUseCase;
import ch.bbv.nosyparrot.backend.usecases.input.GetSurveyDetailsRequest;
import ch.bbv.nosyparrot.backend.usecases.output.GetSurveyDetailsOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.GetSurveyDetailsResponse;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
public class GetSurveyDetailsSteps implements En {
    private Survey expectedSurvey;
    private GetSurveyDetailsOutputPort getSurveyDetailsOutputPort;
    private SurveyEntityGateway surveyEntityGateway;

    public GetSurveyDetailsSteps() {
        When("^I have created survey called \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Long surveyId)
                -> this.expectedSurvey = new Survey(surveyId, surveyTitle));
        And("^I request to get the details of my survey \"([^\"]*)\" identified by (\\d+)$", (String surveyTitle, Long surveyId) -> {
            this.surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);
            Mockito.when(this.surveyEntityGateway.getByIdentifier(surveyId)).thenReturn(this.expectedSurvey);

            GetSurveyDetailsRequest getSurveyDetailsRequest = new GetSurveyDetailsRequest(surveyId);

            this.getSurveyDetailsOutputPort = Mockito.mock(GetSurveyDetailsOutputPort.class);

            GetSurveyDetailsUseCase getSurveyDetailsUseCase = new GetSurveyDetailsUseCase(this.getSurveyDetailsOutputPort, this.surveyEntityGateway);
            getSurveyDetailsUseCase.getSurveyDetails(getSurveyDetailsRequest);
        });
        Then("^I should should receive the details of my survey \"([^\"]*)\" identified by (\\d+)$", (String expectedSurveyTitle, Long expectedSurveyId) -> {
            ArgumentCaptor<GetSurveyDetailsResponse> captor = ArgumentCaptor.forClass(GetSurveyDetailsResponse.class);
            Mockito.verify(this.getSurveyDetailsOutputPort, Mockito.times(1)).presentSurveyDetails(captor.capture());

            GetSurveyDetailsResponse getSurveyDetailsResponse = captor.getValue();
            Survey receivedSurvey = getSurveyDetailsResponse.getSurvey();

            assertThat(receivedSurvey.getId()).isEqualTo(expectedSurveyId);
            assertThat(receivedSurvey.getTitle()).isEqualTo(expectedSurveyTitle);
        });
    }
}
