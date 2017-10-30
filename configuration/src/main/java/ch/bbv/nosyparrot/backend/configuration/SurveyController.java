package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.interfaces.rest.RestController;
import ch.bbv.nosyparrot.backend.interfaces.rest.input.ListSurveysRequestParameter;
import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class SpringSurveyController {
    private RestController restController;

    @Autowired
    public SpringSurveyController(RestController restController) {
        this.restController = restController;
    }

    @GetMapping("/surveys")
    public List<SurveyJson> find(ListSurveysRequestParameter parameters) {
        return new ArrayList<>();
    }
}
