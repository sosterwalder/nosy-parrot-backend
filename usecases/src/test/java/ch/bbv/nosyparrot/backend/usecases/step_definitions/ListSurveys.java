package ch.bbv.nosyparrot.backend.usecases.step_definitions;

import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCaseImpl;
import ch.bbv.nosyparrot.backend.usecases.core.entity.Survey;
import ch.bbv.nosyparrot.backend.usecases.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.core.entity.User;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysRequest;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysOutputPort;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysResponse;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


public class ListSurveys implements En {
    private User surveyUser;
    private List<Survey> surveyList;
    private ListSurveysOutputPort listSurveysOutputPort;
    private SurveyEntityGateway surveyEntityGateway;

    private static long surveyId = 123L;
    private static String surveyName = "surveyName";

    public ListSurveys() {
        Given("^a user is logged in$", () -> {
            this.surveyUser = Mockito.mock(User.class);
        });
        When("^the user has created (\\d+) surveys$", (Integer numberOfSurveys) -> {
            this.surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);
            OngoingStubbing<List> stubbing = when(this.surveyEntityGateway.findByUser(anyLong()));
            this.surveyList = new ArrayList<>();
            IntStream.range(0, numberOfSurveys).forEachOrdered(n -> {
                Survey tempSurvey = new Survey(ListSurveys.surveyId, ListSurveys.surveyName, this.surveyUser);
                this.surveyList.add(tempSurvey);
            });
            stubbing.thenReturn(this.surveyList);
        });
        And("^he asks to retrieve his list of surveys$", () -> {
            ListSurveysRequest listSurveysRequest = new ListSurveysRequest(1234);
            this.listSurveysOutputPort = Mockito.mock(ListSurveysOutputPort.class);
            ListSurveysUseCaseImpl listSurveysUseCase = new ListSurveysUseCaseImpl(listSurveysOutputPort, surveyEntityGateway);
            listSurveysUseCase.listSurveys(listSurveysRequest);
        });
        Then("^the user receives a list containing (\\d+) surveys$", (Integer numberOfSurveys) -> {
            ArgumentCaptor<ListSurveysResponse> listSurveysResponseArgumentCaptor = ArgumentCaptor.forClass(ListSurveysResponse.class);
            verify(this.listSurveysOutputPort, times(1)).presentListOfSurveys(listSurveysResponseArgumentCaptor.capture());
            ListSurveysResponse listSurveysResponse = listSurveysResponseArgumentCaptor.getValue();
            List<Survey> receivedSurveys = listSurveysResponse.getSurveyList();
            assertThat(receivedSurveys).hasSize(numberOfSurveys);
        });
    }
}