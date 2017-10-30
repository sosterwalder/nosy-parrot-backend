package ch.bbv.nosyparrot.backend.core.usecase;

import java.util.function.Consumer;
import ch.bbv.nosyparrot.backend.core.usecase.input.ListSurveysRequest;
import ch.bbv.nosyparrot.backend.core.usecase.output.SurveyResponseModel;


public interface ListSurveysUseCase {
    void execute(ListSurveysRequest request, Consumer<SurveyResponseModel> responseModelFunction);
}
