package sa.osama_alharbi.sda.assigments.week8;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Week8Task5Test {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void userRequestTest(){
        //use url https://reqres.in/api/users/23
        String url = "https://reqres.in/api/users/23";

        //send a GET Request to the url
        Response response = given().get(url);
        System.out.println(response.prettyPrint());

        response
                .then()
                //HTTP Status code should be 404
                .statusCode(404)
                //Status Line should be HTTP/1.1 404 Not Found
                .statusLine("HTTP/1.1 404 Not Found")
                //Server is "cloudflare"
                .header("Server","cloudflare")
                //Response body should be empty
                .body(equalTo("{}"));
    }
}
