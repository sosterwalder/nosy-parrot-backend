package ch.bbv.nosyparrot.backend.interfaces.rest;

import java.util.List;

import ch.bbv.nosyparrot.backend.core.usecase.ListSurveysUseCase;
import ch.bbv.nosyparrot.backend.interfaces.presenter.SurveyResponseModelJsonListRepresenter;
import ch.bbv.nosyparrot.backend.interfaces.rest.input.ListSurveysRequestParameter;
import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;


public class RestController {
    private ListSurveysUseCase listSurveysUseCase;


    public RestController(ListSurveysUseCase listSurveysUseCase) {
        this.listSurveysUseCase = listSurveysUseCase;
    }

    public List<SurveyJson> find(ListSurveysRequestParameter parameters) {
        final SurveyResponseModelJsonListRepresenter presenter = new SurveyResponseModelJsonListRepresenter();
        listSurveysUseCase.execute(parameters.toRequest(), presenter);

        return presenter.getSurveyJsonList();
    }
}
