package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.SurveyEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.SurveyJpaEntityRepository;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.UserJpaEntityGateway;
import ch.bbv.nosyparrot.backend.frameworks.springjpa.UserJpaEntityRepository;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interactors.UserInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.UserController;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import ch.bbv.nosyparrot.backend.interfaces.output.UserPresenter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories({"ch.bbv.nosyparrot.backend.frameworks.springjpa"})
@EntityScan("ch.bbv.nosyparrot.backend.frameworks.springjpa")
@SuppressWarnings("unused")
public class AppConfig {
    private SurveyEntityGateway surveyEntityGateway;
    private UserJpaEntityGateway userJpaEntityGateway;

    public AppConfig(
            SurveyJpaEntityRepository surveyJpaEntityRepository,
            UserJpaEntityRepository userJpaEntityRepository
    ) {
        this.surveyEntityGateway = new SurveyJpaEntityGateway(surveyJpaEntityRepository);
        this.userJpaEntityGateway = new UserJpaEntityGateway(userJpaEntityRepository);
    }

    @Bean
    @SuppressWarnings("WeakerAccess")
    public SurveyPresenter surveyPresenter() {
        return new SurveyPresenter();
    }

    @Bean
    @SuppressWarnings("WeakerAccess")
    public SurveyController surveyController() {
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

    @Bean
    public UserJpaEntityGateway userJpaEntityGateway() {
        return this.userJpaEntityGateway;
    }

    @Bean
    public UserPresenter userPresenter() {
        return new UserPresenter();
    }

    @Bean
    public UserController userController() {
        UserInteractor userInteractor = new UserInteractor(this.userPresenter(), this.userJpaEntityGateway);

        return new UserController(userInteractor);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
