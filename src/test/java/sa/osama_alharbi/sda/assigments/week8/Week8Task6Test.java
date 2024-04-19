package sa.osama_alharbi.sda.assigments.week8;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sa.osama_alharbi.sda.assigments.classes.Week8Task6BaseUrl;

import static io.restassured.RestAssured.given;

public class Week8Task6Test extends Week8Task6BaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
            "data": {
                "id": 3,
                "name": "true red",
                "year": 2002,
                "color": "#BF1932",
                "pantone_value": "19-1664"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
     */

    @Test
    void userRequestTest(){
        //https://reqres.in/api/unknown/3
        //send a GET request to the URL
        spec.pathParams("first", "unknown", "second", "3");

        Response response = given().spec(spec)
                .get("/{first}/{second}")
                .then()
                //HTTP Status Code should be 200
                .statusCode(200)
                //Response content type is "application/json; charset=utf-8"
                .contentType("application/json; charset=utf-8")
                .extract()
                .response();

        response.prettyPrint();


        //Response body should be like;(Soft Assertion)
        JsonPath jsonPath = response.jsonPath();

        int id               = jsonPath.getInt("data.id");
        String name          = jsonPath.getString("data.name");
        int year             = jsonPath.getInt("data.year");
        String color         = jsonPath.getString("data.color");
        String pantone_value = jsonPath.getString("data.pantone_value");
        String url           = jsonPath.getString("support.url");
        String text          = jsonPath.getString("support.text");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(id,3);
        softAssert.assertEquals(name,"true red");
        softAssert.assertEquals(year,2002);
        softAssert.assertEquals(color,"#BF1932");
        softAssert.assertEquals(pantone_value,"19-1664");
        softAssert.assertEquals(url,"https://reqres.in/#support-heading");
        softAssert.assertEquals(text,"To keep ReqRes free, contributions towards server costs are appreciated!");
        softAssert.assertAll();
    }
}
