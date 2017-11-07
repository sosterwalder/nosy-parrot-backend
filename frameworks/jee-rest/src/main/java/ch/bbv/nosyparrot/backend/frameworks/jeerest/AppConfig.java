package ch.bbv.nosyparrot.backend.frameworks.jeerest;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(new ApplicationBinder());
    }
}
