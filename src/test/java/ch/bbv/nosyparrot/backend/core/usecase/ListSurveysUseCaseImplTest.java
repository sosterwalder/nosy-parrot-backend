package ch.bbv.nosyparrot.backend.core.usecase;


import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.entity.SurveyFactory;
import ch.bbv.nosyparrot.backend.core.usecase.input.ListSurveysRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class ListSurveysUseCaseImplTest {
    private ListSurveysUseCase listSurveysUseCase;
    private SurveyEntityGateway surveyEntityGateway;

    @BeforeEach
    public void initializeComponentUnderTest() {
        surveyEntityGateway = Mockito.mock(SurveyEntityGateway.class);
        listSurveysUseCase = new ListSurveysUseCaseImpl(surveyEntityGateway);
    }

    @Test
    public void returnSurvey_whenOneSurveysIsPresent() {
        String surveyId = "surveyId";
        String surveyTitle = "surveyTitle";

        // Given
        List<Survey> surveyList = new ArrayList<>();
        surveyList.add(SurveyFactory.create().createSurvey(surveyId, surveyTitle));
        doReturn(surveyList).when(surveyEntityGateway).findAll();
        ListSurveysRequest request = new ListSurveysRequest.Builder().build();

        // When
        List<String> ids = new ArrayList<>();
        listSurveysUseCase.execute(request, surveyResponseModel -> ids.add(surveyResponseModel.getId()));

        // Then
        assertThat(ids).hasSize(1);
        assertThat(ids.stream().anyMatch(item -> surveyId.equals(item)));
    }
}