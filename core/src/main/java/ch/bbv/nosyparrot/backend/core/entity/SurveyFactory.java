package ch.bbv.nosyparrot.backend.core.entity;


public class SurveyFactory {
    private SurveyFactory() {}

    public Survey createSurvey(String id, String title, User user) {
        return new Survey(id, title, user);
    }

    public static SurveyFactory create() {
        return new SurveyFactory();
    }
}
