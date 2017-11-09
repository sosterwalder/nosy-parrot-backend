package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interfaces.CreateSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.CreateSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.output.CreateSurveysViewModel;
import ch.bbv.nosyparrot.backend.usecases.CreateSurveysUseCase;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SurveyRestController {
    private final ListSurveysUseCase listSurveysUseCase;
    private final ListSurveysPresenter listSurveysPresenter;
    private final CreateSurveysUseCase createSurveysUseCase;
    private final CreateSurveysPresenter createSurveysPresenter;

    public SurveyRestController(
            ListSurveysUseCase listSurveysUseCase,
            ListSurveysPresenter listSurveysPresenter,
            CreateSurveysUseCase createSurveysUseCase,
            CreateSurveysPresenter createSurveysPresenter
    ) {
        this.listSurveysUseCase = listSurveysUseCase;
        this.listSurveysPresenter = listSurveysPresenter;
        this.createSurveysUseCase = createSurveysUseCase;
        this.createSurveysPresenter = createSurveysPresenter;
    }

    @RequestMapping("/surveys")
    public List<Survey> surveys() {
        ListSurveysController listSurveysController = new ListSurveysController(listSurveysUseCase);
        listSurveysController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = this.listSurveysPresenter.getListSurveysViewModel();

        return listSurveysViewModel.getSurveyList();
    }

    @PostMapping(value = "/surveys/new")
    public List<Survey> createSurvey(@RequestBody String surveyTitle) {
        CreateSurveysController createSurveysController = new CreateSurveysController(createSurveysUseCase);
        createSurveysController.createSurvey(surveyTitle);
        CreateSurveysViewModel createSurveysViewModel = this.createSurveysPresenter.getCreateSurveysViewModel();

        return createSurveysViewModel.getSurveyList();
    }
}
