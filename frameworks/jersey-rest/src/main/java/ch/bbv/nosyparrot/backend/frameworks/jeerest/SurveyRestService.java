package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.frameworks.hibernatejpa.SurveyService;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/surveys")
public class SurveyRestService {
    private final SurveyPresenter surveyPresenter;
    private final SurveyController surveyController;

    public SurveyRestService() {
        final SurveyService surveyService = new SurveyService();

        this.surveyPresenter = new SurveyPresenter();

        SurveyInteractor surveyInteractor = new SurveyInteractor(this.surveyPresenter, surveyService);
        this.surveyController = new SurveyController(surveyInteractor);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Survey> surveys() {
        this.surveyController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return listSurveysViewModel.getSurveyList();
    }

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Survey> createSurvey(String surveyTitle) {
        this.surveyController.createSurvey(surveyTitle);
        ListSurveysViewModel listSurveysViewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return listSurveysViewModel.getSurveyList();
    }
}
