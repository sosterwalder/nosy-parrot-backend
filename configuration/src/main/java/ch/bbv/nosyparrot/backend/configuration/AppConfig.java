package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.configuration.security.JpaUserEntityGateway;
import ch.bbv.nosyparrot.backend.configuration.security.UserDetailsServiceImpl;
import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.core.usecase.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.core.usecase.ListSurveysUseCaseImpl;
import ch.bbv.nosyparrot.backend.interfaces.rest.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class AppConfig {
    @Bean
    public RestController getRestController() {
        final SurveyEntityGateway surveyEntityGateway = new JpaSurveyEntityGateway();
        final ListSurveysUseCase listSurveysUseCase = new ListSurveysUseCaseImpl(surveyEntityGateway);

        return new RestController(listSurveysUseCase);
    }
}
