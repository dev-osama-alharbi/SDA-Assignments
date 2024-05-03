package sa.osama_alharbi.sda.assigments.week10;

import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task15BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.T15UserPojo;
import sa.osama_alharbi.sda.assigments.pojo.T15UserPostResponsePojo;
import sa.osama_alharbi.sda.assigments.pojo.T16ContactPojo;
import sa.osama_alharbi.sda.assigments.pojo.T16ContactResponsePojo;
import sa.osama_alharbi.sda.assigments.utils.AuthenticationTask15;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Week9Task16Test extends Week9Task15BaseUrl {
    /*
        //Write an automation test that will add a 'contact' then read, update and delete the created contact then negative assert the deleted
         contact using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.
    */

    private T15UserPojo user = T15UserPojo
            .builder()
            .firstName("osama")
            .lastName("alharbi")
            .email("osama@example.com")
            .password("123123123")
            .build();

    private T16ContactPojo contact = T16ContactPojo
            .builder()
            .firstName("osama")
            .lastName("alharbi")
            .birthdate("1996-12-12")
            .email("osama@example.com")
            .phone("00966966966966")
            .street1("asdasdasdasdasd")
            .street2("asdasdasdasdasdas")
            .city("Makkah")
            .stateProvince("Makkah")
            .postalCode("12312")
            .country("Saudi Arabia")
            .build();

    @Test(priority = 0)
    public void createUserTest() {
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
    public void createContactTest() {
        //Set the url
        spec.pathParams("first", "contacts");
        //Send the request and get the response
        Response response = given(spec).body(contact).post("{first}");
        response.prettyPrint();
        //Do assertion
        response.then()
                .statusCode(201)
                .body(
                        "firstName",equalTo(contact.getFirstName()),
                        "lastName",equalTo(contact.getLastName()),
                        "birthdate",equalTo(contact.getBirthdate()),
                        "email",equalTo(contact.getEmail()),
                        "phone",equalTo(contact.getPhone()),
                        "street1",equalTo(contact.getStreet1()),
                        "street2",equalTo(contact.getStreet2()),
                        "city",equalTo(contact.getCity()),
                        "stateProvince",equalTo(contact.getStateProvince()),
                        "postalCode",equalTo(contact.getPostalCode()),
                        "country",equalTo(contact.getCountry())
                );

    }

    @Test(priority = 2)
    public void readContactTest() {
        //Set the url
//        spec.pathParams("first", "contacts");
        //Send the request and get the response
        Response response = given(spec).get("contacts");
        response.prettyPrint();

        //Do assertion
        ArrayList<T16ContactResponsePojo> contactResponseList = response.as(new TypeRef<ArrayList<T16ContactResponsePojo>>(){});
        T16ContactResponsePojo contactResponse = contactResponseList.get(0);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(contactResponse.getFirstName(),contact.getFirstName());
        Assert.assertEquals(contactResponse.getLastName(),contact.getLastName());
        Assert.assertEquals(contactResponse.getBirthdate(),contact.getBirthdate());
        Assert.assertEquals(contactResponse.getEmail(),contact.getEmail());
        Assert.assertEquals(contactResponse.getPhone(),contact.getPhone());
        Assert.assertEquals(contactResponse.getStreet1(),contact.getStreet1());
        Assert.assertEquals(contactResponse.getStreet2(),contact.getStreet2());
        Assert.assertEquals(contactResponse.getCity(),contact.getCity());
        Assert.assertEquals(contactResponse.getStateProvince(),contact.getStateProvince());
        Assert.assertEquals(contactResponse.getPostalCode(),contact.getPostalCode());
        Assert.assertEquals(contactResponse.getCountry(),contact.getCountry());
    }

    @Test(priority = 3)
    public void updateContactFirstNameTest() {
        String jsonBody = """
                {
                    "firstName": "osamah"
                }
                """;

        //Set the url
        spec.pathParams("first", "contacts");
        //Send the request and get the response
        Response response = given(spec).body(contact).patch("{first}/");
        response.prettyPrint();

        //Do assertion
        T16ContactResponsePojo actualDataList = response.as(T16ContactResponsePojo.class);
        System.out.println("actualDataList = " + actualDataList);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualDataList.getFirstName(), "osamah");

    }

    @Test(priority = 4)
    public void deleteContactTest() {
        //Set the url
//        spec.pathParams("first", "contacts");
        //Send the request and get the response
        Response response = given(spec).delete("contacts/");
        response.prettyPrint();

        //Do assertion
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(priority = 5)
    public void deleteUserTest() {
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
