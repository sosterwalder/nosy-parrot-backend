package ch.bbv.nosyparrot.backend.interfaces.step_definitions;


import ch.bbv.nosyparrot.backend.core.entity.User;
import ch.bbv.nosyparrot.backend.features.World;
import cucumber.api.java8.En;
import org.mockito.Mockito;

@SuppressWarnings("unused")
public class CommonSteps implements En {
    private World world;

    public CommonSteps(World world) {
        this.world = world;

        Given("^a registered user named \"([^\"]*)\"$", (String username) -> {
            User user = Mockito.mock(User.class);
            user.setUsername(username);
            this.world.setUser(user);
        });
        And("^I am a logged-in as \"([^\"]*)\"$", (String username) -> {
            // TODO: Perform login mock
        });
    }
}
