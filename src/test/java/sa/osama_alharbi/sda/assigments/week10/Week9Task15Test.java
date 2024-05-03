package sa.osama_alharbi.sda.assigments.week10;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task15BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.*;
import sa.osama_alharbi.sda.assigments.utils.AuthenticationTask15;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

public class Week9Task15Test extends Week9Task15BaseUrl {
    /*
        //Write an automation test that will create a 'user' then read, update and delete
         the created user using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.
    */

    private T15UserPojo user = T15UserPojo
            .builder()
            .firstName("osama")
            .lastName("alharbi")
            .email("osama@example.com")
            .password("123123123")
            .build();

    @Test(priority = 0)
    public void createTest() {
        T15UserPojo bodyData = T15UserPojo
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        //Set the url
        spec.pathParams("first", "users");
        //Send the request and get the response
        Response response = given(spec).body(bodyData).post("{first}");
        response.prettyPrint();
        //Do assertion
        response.then()
                .statusCode(201)
                .body(
                        "user.firstName",equalTo(bodyData.getFirstName()),
                        "user.lastName",equalTo(bodyData.getLastName()),
                        "user.email",equalTo(bodyData.getEmail())
                );

    }
    @Test(priority = 1)
    public void readTest() {
        //Set the url
        spec.pathParams("first", "users","second","me");
        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .body(
                        "firstName",equalTo(user.getFirstName()),
                        "lastName",equalTo(user.getLastName()),
                        "email",equalTo(user.getEmail())
                );

    }
    @Test(priority = 2)
    public void updateTest() {
        T15UserPojo bodyData = T15UserPojo
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName()+"v2")
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        //Set the url
        spec.pathParams("first", "users","second","me");
        //Send the request and get the response
        Response response = given(spec).body(bodyData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        T15UserPostResponsePojo actualDataList = response.as(T15UserPostResponsePojo.class);
        System.out.println("actualDataList = " + actualDataList);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualDataList.getLastName(), bodyData.getLastName());

    }

    @Test(priority = 3)
    public void deleteTest() {
        //Set the url
        spec.pathParams("first", "users","second","me");
        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Assert.assertEquals(response.statusCode(), 200);
        AuthenticationTask15.token = "";

    }
}
