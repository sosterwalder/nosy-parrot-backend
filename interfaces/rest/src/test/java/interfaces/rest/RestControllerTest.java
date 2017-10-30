package interfaces.rest;


import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.core.usecase.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.core.usecase.ListSurveysUseCaseImpl;
import ch.bbv.nosyparrot.backend.interfaces.rest.RestController;
import ch.bbv.nosyparrot.backend.interfaces.rest.input.ListSurveysRequestParameter;
import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


public class RestControllerTest {
    @Test
    public void returnSurvey_whenOneSurveysIsPresent() {
        // Given
        String surveyId = "surveyId";
        String surveyTitle = "surveyTitle";
        User surveyUser = Mockito.mock(User.class);
        Survey testee = new Survey(surveyId, surveyTitle, surveyUser);

        ListSurveysRequestParameter mockedParams = Mockito.mock(ListSurveysRequestParameter.class);
        List<Survey> surveyList = new ArrayList<>();
        surveyList.add(testee);

        SurveyEntityGateway surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);
        when(surveyEntityGateway.findAll()).thenReturn(surveyList);

        ListSurveysUseCaseImpl listSurveysUseCase = new ListSurveysUseCaseImpl(surveyEntityGateway);
        RestController restController = new RestController(listSurveysUseCase);

        // When
        List<SurveyJson> surveyJsonList = restController.find(mockedParams);

        // Then
        assertThat(surveyJsonList).hasSize(1);
        assertThat(surveyJsonList.stream().anyMatch(survey -> surveyId.equals(survey.getId())));
        assertThat(surveyJsonList.stream().anyMatch(survey -> surveyTitle.equals(survey.getTitle())));
        assertThat(surveyJsonList.stream().anyMatch(survey -> surveyUser.equals(survey.getUser())));
    }
}
