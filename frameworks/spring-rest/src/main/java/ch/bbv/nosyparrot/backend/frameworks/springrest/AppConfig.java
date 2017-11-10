package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityRepository;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories({"ch.bbv.nosyparrot.backend.frameworks.springjpa"})
@EntityScan("ch.bbv.nosyparrot.backend.frameworks.springjpa")
@SuppressWarnings("unused")
public class AppConfig {
    private final SurveyEntityGateway surveyEntityGateway;

    public AppConfig(SurveyJpaEntityRepository surveyJpaEntityRepository) {
        this.surveyEntityGateway = new SurveyJpaEntityGateway(surveyJpaEntityRepository);
    }

    @Bean
    @SuppressWarnings("WeakerAccess")
    public SurveyPresenter surveyPresenter() {
        return new SurveyPresenter();
    }

    @Bean
    @SuppressWarnings("WeakerAccess")
    public SurveyController surveyController() {
        SurveyPresenter surveyPresenter = new SurveyPresenter();
        SurveyInteractor surveyInteractor = new SurveyInteractor(this.surveyPresenter(), this.surveyEntityGateway);
        return new SurveyController(surveyInteractor);
    }

    @Bean
    public SurveyRestController surveyRestController() {
        return new SurveyRestController(
                this.surveyController(),
                this.surveyPresenter()
        );
    }
}
