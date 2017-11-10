package ch.bbv.nosyparrot.backend.interfaces.step_definitions;

import ch.bbv.nosyparrot.backend.interactors.input.SurveyInputPort;
import ch.bbv.nosyparrot.backend.interactors.output.ListSurveysResponse;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import cucumber.api.java8.En;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@SuppressWarnings("unused")
public class ListSurveysSteps implements En {
    private List<Survey> surveyList;
    private static long userId = 123L;
    private static long surveyId = 123L;
    private static String surveyTitle = "surveyTitle";

    public ListSurveysSteps() {
        When("^\"([^\"]*)\" has created (\\d+) surveys$", (String username, Integer numberOfCreatedSurveys) -> {
            this.surveyList = new ArrayList<>();
            IntStream.range(0, numberOfCreatedSurveys).forEachOrdered(n -> {
                Survey tempSurvey = new Survey(ListSurveysSteps.surveyId, ListSurveysSteps.surveyTitle);
                this.surveyList.add(tempSurvey);
            });
        });
        And("^she asks to retrieve her list of surveys$", () -> {
            SurveyInputPort surveyInputPort = Mockito.mock(SurveyInputPort.class);
            SurveyController surveyController = new SurveyController(surveyInputPort);
            surveyController.getSurveys();
        });
        Then("^she receives a list containing (\\d+) surveys$", (Integer numberOfExpectedSurveys) -> {
            SurveyPresenter surveyPresenter = new SurveyPresenter();

            ListSurveysResponse listSurveysResponse = mock(ListSurveysResponse.class);
            when(listSurveysResponse.getSurveyList()).thenReturn(this.surveyList);

            surveyPresenter.presentListOfSurveys(listSurveysResponse);

            ArgumentCaptor<ListSurveysViewModel> listSurveysViewModelArgumentCaptor = ArgumentCaptor.forClass(ListSurveysViewModel.class);
            ListSurveysViewModel receivedSurveysViewModel = (ListSurveysViewModel) surveyPresenter.getSurveyViewModel();
            List<Survey> receivedSurveys = receivedSurveysViewModel.getSurveyList();

            assertThat(receivedSurveys).hasSize(numberOfExpectedSurveys);
            assertThat(receivedSurveys).isEqualTo(this.surveyList);
        });
    }
}
