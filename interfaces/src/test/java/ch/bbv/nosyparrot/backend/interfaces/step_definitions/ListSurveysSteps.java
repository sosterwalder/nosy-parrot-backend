package ch.bbv.nosyparrot.backend.interfaces.step_definitions;

import ch.bbv.nosyparrot.backend.interfaces.ListSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysPresenterOutputPort;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysRequest;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysResponse;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class ListSurveysSteps implements En {
    private User surveyUser;
    private List<Survey> surveyList;
    private static long userId = 123L;
    private static long surveyId = 123L;
    private static String surveyTitle = "surveyTitle";

    public ListSurveysSteps() {
        Given("^a user is logged in$", () -> {
            this.surveyUser = mock(User.class);
            when(this.surveyUser.getId()).thenReturn(ListSurveysSteps.userId);
        });
        When("^the user has created (\\d+) surveys$", (Integer numberOfCreatedSurveys) -> {
            this.surveyList = new ArrayList<>();
            IntStream.range(0, numberOfCreatedSurveys).forEachOrdered(n -> {
                Survey tempSurvey = new Survey(ListSurveysSteps.surveyId, ListSurveysSteps.surveyTitle);
                this.surveyList.add(tempSurvey);
            });
        });
        And("^he asks to retrieve his list of surveys$", () -> {
            ListSurveysInputPort listSurveysInputPort = mock(ListSurveysInputPort.class);
            ListSurveysController listSurveysController = new ListSurveysController(listSurveysInputPort);

            // listSurveysController.getSurveysForUserId(this.surveyUser.getId());
            listSurveysController.getSurveys();

            // ArgumentCaptor<ListSurveysRequest> listSurveysRequestArgumentCaptor = ArgumentCaptor.forClass(ListSurveysRequest.class);
            // verify(listSurveysInputPort, times(1)).listSurveys(listSurveysRequestArgumentCaptor.capture());
            // final long receivedUserId = listSurveysRequestArgumentCaptor.getValue()
            // assertThat(receivedUserId).isEqualTo(ListSurveysSteps.userId);
        });
        Then("^the user receives a list containing (\\d+) surveys$", (Integer numberOfExpectedSurveys) -> {
            ListSurveysPresenter listSurveysPresenter = new ListSurveysPresenter();

            ListSurveysResponse listSurveysResponse = mock(ListSurveysResponse.class);
            when(listSurveysResponse.getSurveyList()).thenReturn(this.surveyList);

            listSurveysPresenter.presentListOfSurveys(listSurveysResponse);

            ArgumentCaptor<ListSurveysViewModel> listSurveysViewModelArgumentCaptor = ArgumentCaptor.forClass(ListSurveysViewModel.class);
            ListSurveysViewModel receivedSurveysViewModel = listSurveysPresenter.getListSurveysViewModel();
            List<Survey> receivedSurveys = receivedSurveysViewModel.getSurveyList();

            assertThat(receivedSurveys).hasSize(numberOfExpectedSurveys);
            assertThat(receivedSurveys).isEqualTo(this.surveyList);
        });
    }
}
