package ch.bbv.nosyparrot.backend.frameworks.jeerest;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Application {
    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig resourceConfig = new ResourceConfig(SurveyRestService.class);
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);

        System.out.println("Press enter to stop the server...");
        System.in.read();

        httpServer.shutdown();
    }
}
