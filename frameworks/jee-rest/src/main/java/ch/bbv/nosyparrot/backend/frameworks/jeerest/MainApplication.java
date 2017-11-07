package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MainApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resourceSet = new HashSet<>();
        resourceSet.add(AppConfig.class);
        resourceSet.add(SurveyRestService.class);

        return resourceSet;
    }
}
