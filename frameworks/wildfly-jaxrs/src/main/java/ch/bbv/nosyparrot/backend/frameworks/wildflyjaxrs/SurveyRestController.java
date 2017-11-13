package ch.bbv.nosyparrot.backend.frameworks.wildflyjaxrs;

import ch.bbv.nosyparrot.backend.core.entity.Survey;
import ch.bbv.nosyparrot.backend.frameworks.hibernatejpa.SurveyService;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.ListSurveysViewModel;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/surveys")
@Api(value = "/surveys", description = "Get surveys", tags = {"survey"})
public class SurveyRestController {
    private SurveyController surveyController;
    private SurveyPresenter surveyPresenter;

    public SurveyRestController() {
        this.surveyPresenter = new SurveyPresenter();
        SurveyService surveyService = new SurveyService();
        SurveyInteractor surveyInteractor = new SurveyInteractor(this.surveyPresenter, surveyService);
        this.surveyController = new SurveyController(surveyInteractor);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all currently available surveys",
        response = String.class
    )
    public List<Survey> surveys() {
        this.surveyController.getSurveys();
        ListSurveysViewModel listSurveysViewModel = (ListSurveysViewModel) this.surveyPresenter.getSurveyViewModel();

        return listSurveysViewModel.getSurveyList();
    }
}
