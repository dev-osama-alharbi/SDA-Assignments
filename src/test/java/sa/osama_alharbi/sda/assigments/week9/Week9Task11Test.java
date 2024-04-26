package sa.osama_alharbi.sda.assigments.week9;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task11BaseUrl;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Week9Task11Test extends Week9Task11BaseUrl {
    /*
        Given
            https://automationexercise.com/api/productsList
        When
            User sends a GET request
        Then
            Assert that the number of "Women" user type is 12
        Note: Print using JsonPath: response.jsonPath().prettyPrint();
    */

    @Test
    public void createUserTest(){
        spec.pathParams("first", "productsList");

        Response response = given().spec(spec).get("/{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> womenUserTypeList = jsonPath.getList("products.findAll { it.category.usertype.usertype == 'Women' }.category.usertype.usertype");

        Assert.assertEquals(womenUserTypeList.size(), 12);
    }
}
