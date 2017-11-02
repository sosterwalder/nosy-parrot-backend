package ch.bbv.nosyparrot.backend.usecases.input;


public class ListSurveysRequest {
    private final long userId;

    public ListSurveysRequest(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
