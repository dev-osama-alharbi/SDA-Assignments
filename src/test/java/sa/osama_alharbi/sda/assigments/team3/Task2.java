package sa.osama_alharbi.sda.assigments.team3;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Task2BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.UserModel;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Task2 extends Task2BaseUrl {
    /*
        // Given https://gorest.co.in/public/v2/users
        // When user send Request  via POST Method
        // Then Status Assert that status code is "422"
        // POST BODY :
        /*
        { "name": "Tenali Ramakrishna",
          "gender": "male",
          "email": "tenali.ramakrishna1@15ce.com",
          "status": "active"
        }

        // HEADERS : Authorization : Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0
     */

    @Test
    public void taskTest(){
        spec.pathParams("first","v2","second","users");
//        UserModel userModel = new UserModel("Osama","male",testEmail2(),"active");
        UserModel userModel = new UserModel("Osama","male","tenali.ramakrishna1@15ce.com","active");
        // HEADERS : Authorization : Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("Authorization","Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0");
        Response response = given(spec)
//                .header("Authorization","Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0")
                .headers(headerMap)
                .body(userModel)
                .post("/{first}/{second}");
        response.prettyPrint();

        // When user send Request  via POST Method
        System.out.println("response.statusCode() => "+response.statusCode());
        response
                .then()
                // Then Status Assert that status code is "422"
                .statusCode(422);

    }

    public String testEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String testEmail2(){
        return "email_"+System.currentTimeMillis()+"@gmail.com";
    }
}
