package ch.bbv.nosyparrot.backend.core.usecase;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import ch.bbv.nosyparrot.backend.core.usecase.output.SurveyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ListSurveysUseCaseTest {

    @Mock
    private SurveyRepository surveyRepository;
    private ListSurveysUseCase listSurveysUseCase;

    @Before
    public void setUp() throws Exception {
        listSurveysUseCase = new ListSurveysUseCase(surveyRepository);
    }

    @Test
    public void returnAnEmptyList_whenNoSurveysAreAvailable() throws Exception {
        List<Survey> surveyList = listSurveysUseCase.getSurveys();
        assertThat(surveyList).isEmpty();
    }

    @Test
    public void returnAListWithASurvey_whenOneSurveyIsAvailable() throws Exception {
        Survey testee = Mockito.mock(Survey.class);
        when(testee.getTitle()).thenReturn("Some title");

        ArrayList<Survey> expectedSurveys = new ArrayList<>();
        expectedSurveys.add(testee);
        when(surveyRepository.getSurveys()).thenReturn(expectedSurveys);

        List<Survey> surveyList = listSurveysUseCase.getSurveys();

        assertThat(surveyList).isNotEmpty();
        assertThat(surveyList).hasSize(1);

        String title = surveyList.get(0).getTitle();
        assertThat(title).isEqualTo(testee.getTitle());
    }
}
