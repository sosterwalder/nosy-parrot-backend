package ch.bbv.nosyparrot.backend.interfaces;

import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysInputPort;
import ch.bbv.nosyparrot.backend.usecases.input.ListSurveysRequest;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ListSurveysControllerTest {
    @Test
    public void getUserIdFromBoundary_whenSurveysForAUserAreRequested() {
        // Given
        final long expectedUserId = 1234L;
        ListSurveysInputPort listSurveysInputPort = Mockito.mock(ListSurveysInputPort.class);
        ListSurveysController testee = new ListSurveysController(listSurveysInputPort);

        // When
        testee.getSurveysForUserId(expectedUserId);

        // Then
        ArgumentCaptor<ListSurveysRequest> listSurveysRequestArgumentCaptor = ArgumentCaptor.forClass(ListSurveysRequest.class);
        verify(listSurveysInputPort, times(1)).listSurveys(listSurveysRequestArgumentCaptor.capture());
        ListSurveysRequest listSurveysRequest = listSurveysRequestArgumentCaptor.getValue();
        long receivedUserId = listSurveysRequest.getUserId();
        assertThat(receivedUserId).isEqualTo(expectedUserId);
    }
}
