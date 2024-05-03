package sa.osama_alharbi.sda.assigments.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationTask15 {
    public static String token = "";
    public static String generateToken(){
        if(!token.isEmpty()){
            return token;
        }

        //This method will send a post request to the url and take a response.
        //Then it will take the token from response and return it as String.

        String strJson = """
                {
                    "email" : "osama@example.com",
                    "password" : "123123123"
                }
                """;
        Response response = given()
                .contentType(ContentType.JSON)
                .body(strJson)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        if(response.asPrettyString().isBlank()){
            return "{{token}}";
        }
        token = response.jsonPath().getString("token");
        return token;

    }
}
