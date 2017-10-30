package ch.bbv.nosyparrot.backend.core.usecase.output;


public class SurveyResponseModel {
    private final String id;
    private final String title;

    public SurveyResponseModel(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
