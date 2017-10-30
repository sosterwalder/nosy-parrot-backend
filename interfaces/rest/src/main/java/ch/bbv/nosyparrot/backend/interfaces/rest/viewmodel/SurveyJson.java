package ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel;

import ch.bbv.nosyparrot.backend.core.entity.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;


public class SurveyJson  extends ResourceSupport {
    private final String title;
    private final User user;

    @JsonCreator
    public SurveyJson(
            @JsonProperty("title") String title,
            @JsonProperty("user") User user
    ) {
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
