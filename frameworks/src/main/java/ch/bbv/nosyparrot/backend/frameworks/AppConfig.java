package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.usecases.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.usecases.core.step_definitions.listsurveys.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.usecases.core.step_definitions.listsurveys.ListSurveysUseCaseImpl;
import ch.bbv.nosyparrot.backend.interfaces.rest.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Autowired
    private SurveyJpaEntityRepository surveyJpaEntityRepository;

    @Bean
    public RestController getRestController() {
        final SurveyEntityGateway surveyEntityGateway = new SurveyJpaEntityGateway(this.surveyJpaEntityRepository);
        final ListSurveysUseCase listSurveysUseCase = new ListSurveysUseCaseImpl(surveyEntityGateway);

        return new RestController(listSurveysUseCase);
    }
}
