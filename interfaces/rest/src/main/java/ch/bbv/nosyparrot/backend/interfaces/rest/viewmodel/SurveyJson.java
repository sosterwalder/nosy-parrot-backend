package ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;


public class SurveyJson  extends ResourceSupport {
    private final String id;
    private final String title;

    @JsonCreator
    public SurveyJson(
            @JsonProperty("id") String id,
            @JsonProperty("title") String title
    ) {
        this.id = id;
        this.title = title;
    }

    public Link getId() {
        return Link.valueOf(id);
    }

    public String getTitle() {
        return title;
    }
}
