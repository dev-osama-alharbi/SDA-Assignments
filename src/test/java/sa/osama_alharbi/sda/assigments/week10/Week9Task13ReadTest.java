package sa.osama_alharbi.sda.assigments.week10;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task13BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.PetStoreResponsePojo;
import sa.osama_alharbi.sda.assigments.pojo.PetStoreUserPojo;

import static io.restassured.RestAssured.given;

public class Week9Task13ReadTest extends Week9Task13BaseUrl {
    /*
        Write an automation test that will create a 'user' then read, update and delete
        the created user using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
    */

    @Test
    public void pojoListTest() {
        PetStoreUserPojo expectedPetStoreUserResponsePojo = PetStoreUserPojo
                .builder()
                .id(2009)
                .username("osama")
                .firstName("osama")
                .lastName("alharbi")
                .email("osama@osama.com")
                .password("123123")
                .phone("00966966966966")
                .userStatus(0)
                .build();

        //Set the url
        spec.pathParams("first", "user","second","osama");
        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStoreUserPojo actualDataList = response.as(PetStoreUserPojo.class);
        System.out.println("actualDataList = " + actualDataList);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualDataList.getId(), expectedPetStoreUserResponsePojo.getId());
        Assert.assertEquals(actualDataList.getEmail(), expectedPetStoreUserResponsePojo.getEmail());

    }
}
