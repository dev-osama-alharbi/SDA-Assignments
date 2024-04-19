package sa.osama_alharbi.sda.assigments.week8;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Week8Task7Test {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
     */

    @Test
    public void userRequestTest(){
        //Set the Url https://reqres.in/api/unknown/
        Response response= given().get("https://reqres.in/api/unknown/");
        response.prettyPrint();

        JsonPath jsonPath =response.jsonPath();

        //1)Status code is 200
        assertEquals(response.getStatusCode(),200);

        //2)Print all pantone_values
        System.out.println("pantone_values => "+jsonPath.getList("data.pantone_value"));

        //3)Print all ids greater than 3 on the console
        //Assert that there are 3 ids greater than 3
        List<Integer> ids = jsonPath.getList("data.findAll { it.id > 3 }.id");
        System.out.println("IDs greater than 3: " + ids);
        for (int id:ids)
            assertTrue(id > 3);


        //4)Print all names whose ids are less than 3 on the console
        //Assert that the number of names whose ids are less than 3 is 2
        List<String> names=jsonPath.getList("data.findAll { it.id<3 }.name");
        System.out.println("Names with IDs less than 3: "+names);
        assertEquals(2, names.size());
    }
}
