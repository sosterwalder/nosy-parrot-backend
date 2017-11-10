package ch.bbv.nosyparrot.backend.usecases.step_definitions;

import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
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
import static org.mockito.Mockito.*;


@SuppressWarnings("unused")
public class ListSurveysSteps implements En {
    private List<Survey> surveyList;
    private ListSurveysOutputPort listSurveysOutputPort;
    private SurveyEntityGateway surveyEntityGateway;

    private static long surveyId = 123L;
    private static String surveyName = "surveyName";

    public ListSurveysSteps() {
        When("^\"([^\"]*)\" has created (\\d+) surveys$", (String username, Integer numberOfSurveys) -> {
            this.surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);
            OngoingStubbing<List> stubbing = when(this.surveyEntityGateway.getAll());
            this.surveyList = new ArrayList<>();
            IntStream.range(0, numberOfSurveys).forEachOrdered(n -> {
                Survey tempSurvey = new Survey(ListSurveysSteps.surveyId, ListSurveysSteps.surveyName);
                this.surveyList.add(tempSurvey);
            });
            stubbing.thenReturn(this.surveyList);
        });
        And("^she asks to retrieve her list of surveys$", () -> {
            ListSurveysRequest listSurveysRequest = new ListSurveysRequest();
            this.listSurveysOutputPort = Mockito.mock(ListSurveysOutputPort.class);
            ListSurveysUseCase listSurveysUseCase = new ListSurveysUseCase(this.listSurveysOutputPort, this.surveyEntityGateway);
            listSurveysUseCase.listSurveys(listSurveysRequest);
        });
        Then("^she receives a list containing (\\d+) surveys$", (Integer numberOfSurveys) -> {
            ArgumentCaptor<ListSurveysResponse> listSurveysResponseArgumentCaptor = ArgumentCaptor.forClass(ListSurveysResponse.class);
            verify(this.listSurveysOutputPort, times(1)).presentListOfSurveys(listSurveysResponseArgumentCaptor.capture());
            ListSurveysResponse listSurveysResponse = listSurveysResponseArgumentCaptor.getValue();
            List<Survey> receivedSurveys = listSurveysResponse.getSurveyList();
            assertThat(receivedSurveys).hasSize(numberOfSurveys);
        });
    }
}
