package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityRepository;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.output.CreateSurveysPresenter;
import ch.bbv.nosyparrot.backend.usecases.CreateSurveysUseCase;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories({"ch.bbv.nosyparrot.backend.frameworks.springjpa"})
@EntityScan("ch.bbv.nosyparrot.backend.frameworks.springjpa")
public class AppConfig {
    private final SurveyEntityGateway surveyEntityGateway;

    public AppConfig(SurveyJpaEntityRepository surveyJpaEntityRepository) {
        this.surveyEntityGateway = new SurveyJpaEntityGateway(surveyJpaEntityRepository);
    }

    @Bean
    public ListSurveysPresenter listSurveysPresenter() {
        return new ListSurveysPresenter();
    }

    @Bean
    public ListSurveysUseCase listSurveysUseCase() {
        return new ListSurveysUseCase(this.listSurveysPresenter(), this.surveyEntityGateway);
    }

    @Bean
    public CreateSurveysPresenter createSurveysPresenter() {
        return new CreateSurveysPresenter();
    }

    @Bean
    public CreateSurveysUseCase createSurveysUseCase() {
        return new CreateSurveysUseCase(this.createSurveysPresenter(), this.surveyEntityGateway);
    }

    @Bean
    public SurveyRestController surveyRestController() {
        return new SurveyRestController(
                this.listSurveysUseCase(),
                this.listSurveysPresenter(),
                this.createSurveysUseCase(),
                this.createSurveysPresenter()
        );
    }
}
