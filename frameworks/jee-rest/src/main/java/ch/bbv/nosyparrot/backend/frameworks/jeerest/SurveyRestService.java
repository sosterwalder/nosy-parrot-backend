package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import ch.bbv.nosyparrot.backend.core.entity.Survey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;


@Provider
public class SurveyRestService {
    @Path("surveys")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Survey> surveys() {
        return new ArrayList<>();
    }
}
