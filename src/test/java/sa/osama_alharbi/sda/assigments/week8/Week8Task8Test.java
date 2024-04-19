package sa.osama_alharbi.sda.assigments.week8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week8Task8BaseUrl;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Week8Task8Test extends Week8Task8BaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like
            {
                "name": "morpheus",
                "job": "leader",
                "id": "496",
                "createdAt": "2022-10-04T15:18:56.372Z"
            }
     */

    @Test
    void userRequestTest(){
        // use body json
        //{
        //  "name": "morpheus",
        //  "job": "leader"
        //}
        Map<String, Object> body = expectedDataMap(496,"leader","morpheus", "2024-04-19T15:18:56.372Z");
        System.out.println("expectedData => " + body);

        //send POST Request to the Url
        Response response = RestAssured.given(spec)
                .body(body).post();
        response.prettyPrint();



        //4.Do Assertion
        response.then()
                //Status code is 201
                .statusCode(201)
                //And response body should be like
                // {
                //      "name": "morpheus",
                //      "job": "leader",
                //      "id": "496",
                //      "createdAt": "2022-10-04T15:18:56.372Z"
                // }
                .body("name", equalTo(body.get("name")),
                        "job", equalTo(body.get("job")),
                        "id", equalTo(body.get("id")),
                        "createdAt",notNullValue());
    }

    private Map<String,Object> expectedDataMap(Integer id,String job,String name,String createdAt){
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("id",id);
        expectedData.put("job",job);
        expectedData.put("name",name);
        expectedData.put("createdAt",createdAt);
        return expectedData;
    }
}
