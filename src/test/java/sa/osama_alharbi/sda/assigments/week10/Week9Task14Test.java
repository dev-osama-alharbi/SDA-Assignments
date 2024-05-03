package sa.osama_alharbi.sda.assigments.week10;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task14BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.EmployeeListPojo;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

public class Week9Task14Test extends Week9Task14BaseUrl {
    /*
        Given
            https://dummy.restapiexample.com/api/v1/employees
        When
            User sends Get Request to the Url
        Then
            Status code is 200
        And
            There are 24 employees
        And
            "Tiger Nixon" and "Garrett Winters" are among the employees
        And
            The greatest age is 66
        And
            The name of the lowest age is "Tatyana Fitzpatrick"
        And
            Total salary of all employees is 6,644,770
    */

    @Test
    public void pojoListTest() {

        //Set the url
        spec.pathParams("first", "employees");
        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .body(
                        "data",hasSize(24),
                        "data.employee_name", hasItems("Tiger Nixon","Garrett Winters")
                        //TODO The greatest age is 66
                        //"data.employee_age",greaterThanOrEqualTo(66)
                        //TODO The name of the lowest age is "Tatyana Fitzpatrick"
                        //TODO Total salary of all employees is 6,644,770
                );


        EmployeeListPojo actualDataList = response.as(EmployeeListPojo.class);
        System.out.println("actualDataList = " + actualDataList);

        Assert.assertEquals(response.statusCode(), 200);

    }
}
