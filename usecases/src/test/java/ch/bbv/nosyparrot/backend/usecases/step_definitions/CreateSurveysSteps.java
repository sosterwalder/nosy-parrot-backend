package ch.bbv.nosyparrot.backend.usecases.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.CreateSurveysUseCase;
import ch.bbv.nosyparrot.backend.usecases.input.CreateSurveysRequest;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.CreateSurveysResponse;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CreateSurveysSteps implements En {
    private CreateSurveysOutputPort createSurveysOutputPort;
    private SurveyEntityGateway surveyEntityGateway;

    private static final long surveyId = 1L;
    private static final String surveyTitle = "This is teh title 001";

    public CreateSurveysSteps() {
        Given("^I am a logged-in User$", () -> {
            // TODO: Implement registering/logging in
        });
        When("^I create a new survey with a title but without questions$", () -> {
            this.createSurveysOutputPort = Mockito.mock(CreateSurveysOutputPort.class);
            this.surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);

            Survey expectedSurvey = new Survey(CreateSurveysSteps.surveyId, CreateSurveysSteps.surveyTitle);
            List<Survey> expectedSurveyList = new ArrayList<>();
            expectedSurveyList.add(expectedSurvey);
            when(this.surveyEntityGateway.create(anyString())).thenReturn(expectedSurveyList);

            CreateSurveysRequest createSurveyRequest = new CreateSurveysRequest();
            createSurveyRequest.setSurveyTitle(CreateSurveysSteps.surveyTitle);

            CreateSurveysUseCase createSurveysUseCase = new CreateSurveysUseCase(this.createSurveysOutputPort, this.surveyEntityGateway);
            createSurveysUseCase.createSurvey(createSurveyRequest);
        });
        Then("^the survey should appear in my list of surveys$", () -> {
            ArgumentCaptor<CreateSurveysResponse> createSurveysResponseArgumentCaptor = ArgumentCaptor.forClass(CreateSurveysResponse.class);
            verify(this.createSurveysOutputPort, times(1)).presentCreationOfSurvey(createSurveysResponseArgumentCaptor.capture());
            CreateSurveysResponse createSurveysResponse = createSurveysResponseArgumentCaptor.getValue();
            List<Survey> receivedSurveys = createSurveysResponse.getSurveyList();
            assertThat(receivedSurveys).extracting("title").contains(CreateSurveysSteps.surveyTitle);
        });
    }
}
