package ch.bbv.nosyparrot.backend.frameworks.wildflyjaxrs;

import ch.bbv.nosyparrot.backend.frameworks.hibernatejpa.SurveyService;
import ch.bbv.nosyparrot.backend.interactors.SurveyInteractor;
import ch.bbv.nosyparrot.backend.interfaces.SurveyController;
import ch.bbv.nosyparrot.backend.interfaces.output.SurveyPresenter;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;


public class Main {

    public static void main(String... args) throws Exception {
        Swarm swarm = new Swarm();
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addClass(SurveyRestController.class);
        deployment.addAllDependencies();
        swarm.start().deploy(deployment);
    }
}