package ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class SurveyJson {
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

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
