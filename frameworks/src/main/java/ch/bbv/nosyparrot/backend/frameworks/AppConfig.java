package ch.bbv.nosyparrot.backend.frameworks;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.usecases.output.ListSurveysOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Autowired
    private SurveyJpaEntityRepository surveyJpaEntityRepository;

    @Bean
    public SurveyRestController getSurveyRestController() {
        final SurveyEntityGateway surveyEntityGateway = new SurveyJpaEntityGateway(this.surveyJpaEntityRepository);
        final ListSurveysPresenter listSurveysPresenter = new ListSurveysPresenter();
        final ListSurveysUseCase listSurveysUseCase = new ListSurveysUseCase(listSurveysPresenter, surveyEntityGateway);

        return new SurveyRestController(listSurveysUseCase);
    }
}
