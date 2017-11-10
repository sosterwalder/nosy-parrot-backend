package ch.bbv.nosyparrot.backend.interactor.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interactors.input.SurveyRequest;
import ch.bbv.nosyparrot.backend.interactors.output.CreateSurveyResponse;
import ch.bbv.nosyparrot.backend.interactors.output.SurveyOutputPort;
import ch.bbv.nosyparrot.backend.interactors.output.SurveyResponse;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@SuppressWarnings("unused")
public class CreateSurveysSteps implements En {
    private SurveyOutputPort surveyOutputPort;
    private SurveyEntityGateway surveyEntityGateway;

    private static final long surveyId = 1L;

    public CreateSurveysSteps() {
        When("^I create a new survey called \"([^\"]*)\" but without questions$", (String givenSurveyTitle) -> {
            this.surveyOutputPort = Mockito.mock(SurveyOutputPort.class);
            this.surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);

            Survey expectedSurvey = new Survey(CreateSurveysSteps.surveyId, givenSurveyTitle);
            List<Survey> expectedSurveyList = new ArrayList<>();
            expectedSurveyList.add(expectedSurvey);
            when(this.surveyEntityGateway.create(anyString())).thenReturn(expectedSurveyList);

            SurveyRequest surveyRequest = new SurveyRequest();
            surveyRequest.setSurveyTitle(givenSurveyTitle);

            SurveyInteractor surveyInteractor = new SurveyInteractor(this.surveyOutputPort, surveyEntityGateway);
            surveyInteractor.createSurvey(surveyRequest);
        });
        Then("^the survey \"([^\"]*)\" should appear in my list of surveys$", (String expectedSurveyTitle) -> {
            ArgumentCaptor<CreateSurveyResponse> surveyResponseArgumentCaptor = ArgumentCaptor.forClass(CreateSurveyResponse.class);
            verify(this.surveyOutputPort, times(1)).presentCreationOfSurvey(surveyResponseArgumentCaptor.capture());
            CreateSurveyResponse surveyResponse = surveyResponseArgumentCaptor.getValue();
            List<Survey> receivedSurveys = surveyResponse.getSurveyList();
            assertThat(receivedSurveys).extracting("title").contains(expectedSurveyTitle);
        });
    }
}
