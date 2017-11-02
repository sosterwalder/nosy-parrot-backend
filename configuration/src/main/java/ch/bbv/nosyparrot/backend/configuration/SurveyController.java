package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.interfaces.rest.RestController;
import ch.bbv.nosyparrot.backend.interfaces.rest.input.ListSurveysRequestParameter;
import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class SurveyController {
    private RestController restController;

    @Autowired
    public SurveyController(RestController restController) {
        this.restController = restController;
    }

    @GetMapping("/surveys")
    public List<SurveyJson> find(ListSurveysRequestParameter parameters) {
        List<SurveyJson> surveyJsonList = restController.find(parameters);

        return surveyJsonList;
    }
}
