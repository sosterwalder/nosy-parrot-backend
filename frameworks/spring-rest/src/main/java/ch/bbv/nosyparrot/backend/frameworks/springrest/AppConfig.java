package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityRepository;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories({"ch.bbv.nosyparrot.backend.frameworks.springjpa"})
@EntityScan("ch.bbv.nosyparrot.backend.frameworks.springjpa")
public class AppConfig {
    @Autowired
    private SurveyJpaEntityRepository surveyJpaEntityRepository;

    @Bean
    public ListSurveysPresenter listSurveysPresenter() {
        return new ListSurveysPresenter();
    }

    @Bean
    public ListSurveysUseCase listSurveysUseCase() {
        final SurveyEntityGateway surveyEntityGateway = new SurveyJpaEntityGateway(this.surveyJpaEntityRepository);

        return new ListSurveysUseCase(this.listSurveysPresenter(), surveyEntityGateway);
    }

    @Bean
    public SurveyRestController surveyRestController() {
        return new SurveyRestController(this.listSurveysUseCase(), this.listSurveysPresenter());
    }
}
