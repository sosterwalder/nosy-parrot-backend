package ch.bbv.nosyparrot.backend.configuration;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void returnStatusCodeForbidden_whenNoUserIsGiven() throws InterruptedException {
        when()
                .get("/surveys")
                .then()
                .statusCode(403);
    }

    @Test
    public void returnAuthenticationToken_whenLoginIsSuccessful() throws InterruptedException {
        String authHeader =
        given()
                .contentType("application/json")
                .body(this.userJson.toString())
        .when()
                .post("login")
        .then()
                .statusCode(200)
                .extract()
                .header("Authorization");

        assertThat(authHeader).isNotBlank().contains("Authorization").contains("Bearer");
    }

    /*
    @Test
    public void returnAnEmptyList_whenNoSurveysAreAvailable() throws InterruptedException {

        given()
                .contentType("application/json")
                .header("Authorization", authHeader)
        .when()
                .get("/surveys")


        List<SurveyJson> surveyJsonList = Arrays.asList(
                when()
                .get("/surveys")
                .then()
                .statusCode(200)
                .extract()
                .as(SurveyJson[].class)
        );

        assertThat(surveyJsonList).hasSize(0);
    }
    */
}
