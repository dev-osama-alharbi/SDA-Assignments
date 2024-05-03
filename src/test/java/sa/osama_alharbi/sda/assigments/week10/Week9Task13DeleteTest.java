package sa.osama_alharbi.sda.assigments.week10;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task13BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.PetStoreResponsePojo;
import sa.osama_alharbi.sda.assigments.pojo.PetStoreUserPojo;

import static io.restassured.RestAssured.given;

public class Week9Task13DeleteTest extends Week9Task13BaseUrl {
    /*
        Write an automation test that will create a 'user' then read, update and delete
        the created user using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
    */

    @Test
    public void pojoListTest() {
        PetStoreResponsePojo expectedPetStoreResponsePojo = PetStoreResponsePojo
                .builder()
                .code(200)
                .type("unknown")
                .message("osama")
                .build();

        //Set the url
        spec.pathParams("first", "user","second","osama");
        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStoreResponsePojo actualDataList = response.as(PetStoreResponsePojo.class);
        System.out.println("actualDataList = " + actualDataList);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualDataList.getCode(), expectedPetStoreResponsePojo.getCode());
        Assert.assertEquals(actualDataList.getMessage(), expectedPetStoreResponsePojo.getMessage());

    }
}
