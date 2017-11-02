package ch.bbv.nosyparrot.backend.usecases.core.entity;


public class SurveyFactory {
    private SurveyFactory() {}

    public Survey createSurvey(long id, String title, User user) {
        return new Survey(id, title, user);
    }

    public static SurveyFactory create() {
        return new SurveyFactory();
    }
}
