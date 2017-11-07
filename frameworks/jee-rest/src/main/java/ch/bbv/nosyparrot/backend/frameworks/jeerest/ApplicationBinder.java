package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import org.glassfish.hk2.utilities.binding.AbstractBinder;


public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        final ListSurveysPresenter listSurveysPresenter = new ListSurveysPresenter();
        bind(listSurveysPresenter).to(ListSurveysPresenter.class);

        final SurveyEntityGateway surveyEntityGateway = new SurveyDummyEntityGateway();
        final ListSurveysUseCase listSurveysUseCase = new ListSurveysUseCase(listSurveysPresenter, surveyEntityGateway);
        bind(listSurveysUseCase).to(ListSurveysUseCase.class);
    }
}
