package sa.osama_alharbi.sda.assigments.week8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Week8Task3Test {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void userRequestTest(){
        //use url https://reqres.in/api/users/3
        String url = "https://reqres.in/api/users/3";

        //sends a GET Request to the url
        Response response = RestAssured.get(url);
        response.prettyPrint();

        //HTTP Status Code should be 200
        response.then().statusCode(200);

        //Content Type should be JSON
        response.then().contentType("application/json");

        //Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");
    }
}
