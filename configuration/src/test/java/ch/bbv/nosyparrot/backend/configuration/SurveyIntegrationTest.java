package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.interfaces.rest.viewmodel.SurveyJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
public class SurveyIntegrationTest {

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
