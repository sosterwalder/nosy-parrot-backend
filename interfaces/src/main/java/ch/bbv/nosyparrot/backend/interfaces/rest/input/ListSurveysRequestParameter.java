package ch.bbv.nosyparrot.backend.interfaces.rest.input;

import ch.bbv.nosyparrot.backend.usecases.core.step_definitions.listsurveys.input.ListSurveysRequest;


public class ListSurveysRequestParameter {
    public ListSurveysRequest toRequest() {
        final ListSurveysRequest.Builder builder = new ListSurveysRequest.Builder();

        return builder.build();
    }
}
