package sa.osama_alharbi.sda.assigments.week9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task9BaseUrl;

import static io.restassured.RestAssured.given;

public class Week9Task9Test extends Week9Task9BaseUrl {
    /*
        Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
    */

    @Test
    public void createUserTest(){
        spec.pathParams("first","user");
        String jsonBody = """
        {
            "id": 0,
            "username": "osama",
            "firstName": "Osama",
            "lastName": "AL-Harbi",
            "email": "osama@mail.sa",
            "password": "123q123",
            "phone": "0123456789",
            "userStatus": 0  
        }
        """;
        //send the request and get the response
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .post("/{first}");
        response.prettyPrint();

        //Assertion
        response.then().statusCode(200);

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.getInt("code"), 200);
    }
}
