package ch.bbv.nosyparrot.backend.core.entity;


public class SurveyFactory {
    private SurveyFactory() {}

    public Survey createSurvey(long id, String title) {
        return new Survey(id, title);
    }

    public static SurveyFactory create() {
        return new SurveyFactory();
    }
}
