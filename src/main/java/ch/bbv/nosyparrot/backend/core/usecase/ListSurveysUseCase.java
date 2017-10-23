package ch.bbv.nosyparrot.backend.core.usecase;

import java.util.List;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.core.usecase.input.SurveyService;
import ch.bbv.nosyparrot.backend.core.usecase.output.SurveyRepository;


public class ListSurveysUseCase implements SurveyService {

    private SurveyRepository surveyRepository;

    public ListSurveysUseCase(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<Survey> getSurveys() {
        return this.surveyRepository.getSurveys();
    }
}
