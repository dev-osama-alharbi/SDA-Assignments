package sa.osama_alharbi.sda.assigments.week8;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week8Task4BaseUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Week8Task4Test extends Week8Task4BaseUrl {
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
     */

    @Test
    void userRequestTest(){
        Response response=given(spec).get();

        //User send GET Request to the URL
        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("data.email",equalTo("janet.weaver@reqres.in"))
                .body("data.first_name",equalTo("Janet"))
                .body("data.last_name",equalTo("Weaver"))
                .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}
