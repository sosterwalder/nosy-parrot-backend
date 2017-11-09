package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.frameworks.hibernatejpa.SurveyService;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysController;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysPresenter;
import ch.bbv.nosyparrot.backend.interfaces.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.usecases.ListSurveysUseCase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/surveys")
public class SurveyRestService {
    private ListSurveysUseCase listSurveysUseCase;
    private ListSurveysPresenter listSurveysPresenter;

    public SurveyRestService() {
        final SurveyService surveyService = new SurveyService();
        this.listSurveysPresenter = new ListSurveysPresenter();
        this.listSurveysUseCase = new ListSurveysUseCase(this.listSurveysPresenter, surveyService);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Survey> surveys() {
        ListSurveysController listSurveysController = new ListSurveysController(listSurveysUseCase);
        listSurveysController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = this.listSurveysPresenter.getListSurveysViewModel();

        return listSurveysViewModel.getSurveyList();
    }

    public void setListSurveysUseCase(ListSurveysUseCase listSurveysUseCase) {
        this.listSurveysUseCase = listSurveysUseCase;
    }

    public void setListSurveysPresenter(ListSurveysPresenter listSurveysPresenter) {
        this.listSurveysPresenter = listSurveysPresenter;
    }
}
