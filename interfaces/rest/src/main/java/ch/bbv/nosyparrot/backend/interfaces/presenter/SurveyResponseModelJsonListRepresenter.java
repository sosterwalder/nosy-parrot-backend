package ch.bbv.nosyparrot.backend.interfaces.presenter;

import ch.bbv.nosyparrot.backend.core.usecase.output.SurveyResponseModel;
import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SurveyResponseModelJsonListRepresenter implements Consumer<SurveyResponseModel> {
    private List<SurveyJson> surveyJsonList = new ArrayList<>();

    @Override
    public void accept(SurveyResponseModel surveyResponse) {
        surveyJsonList.add(new SurveyJson(surveyResponse.getId(), surveyResponse.getTitle()));
    }

    public List<SurveyJson> getSurveyJsonList() {
        return surveyJsonList;
    }
}
