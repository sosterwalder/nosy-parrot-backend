package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class SurveyIntegrationTest {
    private JSONObject userJson;
    private static boolean setupIsDone = false;

    public SurveyIntegrationTest() throws JSONException {
        this.userJson = new JSONObject()
                .put("username", "user")
                .put("password", "123qwe");
    }

    @Before
    public void setUp() throws Exception {
        if (setupIsDone) {
            return;
        }

        given()
                .contentType("application/json")
                .body(this.userJson.toString())
        .when()
                .post("/users/sign-up")
        .then()
                .statusCode(200);

        setupIsDone = true;
    }

    @Test
    public void returnAnEmptyList_whenNoSurveysAreAvailable() throws InterruptedException {
        List<SurveyJson>  surveyJsonList = when()
                .get("/surveys")
                .then()
                .statusCode(200)
                .extract().as(ArrayList.class);

        assertThat(surveyJsonList).hasSize(0);


    }
}
