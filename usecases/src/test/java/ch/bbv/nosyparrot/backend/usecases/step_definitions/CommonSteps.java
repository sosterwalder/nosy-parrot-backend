package ch.bbv.nosyparrot.backend.usecases.step_definitions;

import ch.bbv.nosyparrot.backend.core.entity.User;
import cucumber.api.java8.En;
import org.mockito.Mockito;

public class CommonSteps implements En {
    private World world;

    public CommonSteps(World world) {
        this.world = world;

        Given("^a registered user named \"([^\"]*)\"$", (String username) -> {
            User user = Mockito.mock(User.class);
            user.setUsername(username);
            this.world.user = user;
        });
        And("^I am a logged-in as \"([^\"]*)\"$", (String username) -> {
            // TODO: Perform login mock
        });
    }
}
