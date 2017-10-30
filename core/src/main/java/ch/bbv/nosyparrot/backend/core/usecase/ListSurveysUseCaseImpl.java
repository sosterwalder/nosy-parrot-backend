package ch.bbv.nosyparrot.backend.core.usecase;


import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.usecase.input.ListSurveysRequest;
import ch.bbv.nosyparrot.backend.core.usecase.output.SurveyResponseModel;

import java.util.List;
import java.util.function.Consumer;

public class ListSurveysUseCaseImpl implements ListSurveysUseCase {
    private final SurveyEntityGateway surveyEntityGateway;

    public ListSurveysUseCaseImpl(SurveyEntityGateway surveyEntityGateway) {
        this.surveyEntityGateway = surveyEntityGateway;
    }

    @Override
    public void execute(ListSurveysRequest request, Consumer<SurveyResponseModel> responseModelFunction) {
        final List<Survey> surveyList = this.findSurveys(request);
        surveyList.stream()
                .map(this::getSurveyResponseModel)
                .forEach(responseModelFunction);
    }

    private SurveyResponseModel getSurveyResponseModel(Survey survey) {
        // TODO: Get survey by user?
        return new SurveyResponseModel(survey.getId(), survey.getTitle());
    }

    private List<Survey> findSurveys(ListSurveysRequest request) {
        return this.surveyEntityGateway.findAll();

    }

}
