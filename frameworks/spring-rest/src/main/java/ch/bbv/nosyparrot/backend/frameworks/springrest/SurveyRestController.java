package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyDetailsViewModel;
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

    @SuppressWarnings("unused")
    @RequestMapping("/surveys")
    public List<Survey> surveys() {
        this.surveyController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return listSurveysViewModel.getSurveyList();
    }

    @SuppressWarnings("unused")
    @PostMapping(value = "/surveys/new")
    public List<Survey> createSurvey(@RequestBody String surveyTitle) {
        this.surveyController.createSurvey(surveyTitle);
        ListSurveysViewModel viewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return viewModel.getSurveyList();
    }

    @SuppressWarnings("unused")
    @RequestMapping("/survey/{surveyId}")
    public Survey getSurveyDetails(@PathVariable(value = "surveyId") long surveyId) {
        this.surveyController.getSurveyDetails(surveyId);
        SurveyDetailsViewModel viewModel = (SurveyDetailsViewModel) this.surveyPresenter.getSurveyViewModel();

        return viewModel.getSurvey();
    }
}
