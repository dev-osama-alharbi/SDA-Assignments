package sa.osama_alharbi.sda.assigments.week9;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task10BaseUrl;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Week9Task10Test extends Week9Task10BaseUrl {
    /*
        Using the https://petstore.swagger.io/ document, write an automation test that finds the number
        of "pets" with the status "available" and asserts that there are more than 100.
    */

    @Test
    public void createUserTest(){
        spec.pathParams("first","pet","second","findByStatus");

        Response response = given()
                .spec(spec)
                .queryParam("status", "available")
                .get("/{first}/{second}");
        response.prettyPrint();

        List<String> statuses = response.jsonPath().getList("findAll { it.status == 'available' }.status");
        Assert.assertTrue(statuses.size() > 100);
    }
}
