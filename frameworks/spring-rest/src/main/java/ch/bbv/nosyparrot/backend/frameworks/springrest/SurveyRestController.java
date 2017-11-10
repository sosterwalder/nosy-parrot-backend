package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SurveyRestController {
    private final SurveyController surveyController;
    private final SurveyPresenter surveyPresenter;

    public SurveyRestController(
            SurveyController surveyController,
            SurveyPresenter surveyPresenter
    ) {
        this.surveyController = surveyController;
        this.surveyPresenter = surveyPresenter;
    }

    @RequestMapping("/surveys")
    public List<Survey> surveys() {
        this.surveyController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return listSurveysViewModel.getSurveyList();
    }

    @PostMapping(value = "/surveys/new")
    public List<Survey> createSurvey(@RequestBody String surveyTitle) {
        this.surveyController.createSurvey(surveyTitle);
        ListSurveysViewModel viewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return viewModel.getSurveyList();
    }
}
