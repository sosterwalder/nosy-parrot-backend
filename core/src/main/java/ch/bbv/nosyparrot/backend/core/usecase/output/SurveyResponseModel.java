package ch.bbv.nosyparrot.backend.core.usecase.output;

import ch.bbv.nosyparrot.backend.core.entity.User;


public class SurveyResponseModel {
    private final String id;
    private final String title;
    private final User user;

    public SurveyResponseModel(String id, String title, User user) {
        this.id = id;
        this.title = title;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
