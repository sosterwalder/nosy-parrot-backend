package ch.bbv.nosyparrot.backend.frameworks.springrest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SurveyRestController {
    private final ListSurveysUseCase listSurveysUseCase;
    private final ListSurveysPresenter listSurveysPresenter;

    public SurveyRestController(
            ListSurveysUseCase listSurveysUseCase,
            ListSurveysPresenter listSurveysPresenter
    ) {
        this.listSurveysUseCase = listSurveysUseCase;
        this.listSurveysPresenter = listSurveysPresenter;
    }

    @RequestMapping("/surveys")
    public List<Survey> surveys() {
        ListSurveysController listSurveysController = new ListSurveysController(listSurveysUseCase);
        listSurveysController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = this.listSurveysPresenter.getListSurveysViewModel();

        return listSurveysViewModel.getSurveyList();
    }
}
