package ch.bbv.nosyparrot.backend.frameworks;

import ch.bbv.nosyparrot.backend.interfaces.ListSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.core.entity.Survey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SurveyRestController {
    private final ListSurveysUseCase listSurveysUseCase;

    public SurveyRestController(ListSurveysUseCase listSurveysUseCase) {
        this.listSurveysUseCase = listSurveysUseCase;
    }

    @RequestMapping("/surveys")
    public List<Survey> surveys(@RequestParam(value = "userId") long userId) {
        ListSurveysController listSurveysController = new ListSurveysController(listSurveysUseCase);
        listSurveysController.getSurveysForUserId(userId);

        ListSurveysPresenter = listSurveysUseCase.get
        ListSurveysViewModel listSurveysViewModel = listSurveysUseCase.listSurveysPresenter.getListSurveysViewModel();

        return listSurveysViewModel.getSurveyList();
    }
}
