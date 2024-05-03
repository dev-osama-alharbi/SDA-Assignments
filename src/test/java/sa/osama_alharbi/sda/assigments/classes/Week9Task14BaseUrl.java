package sa.osama_alharbi.sda.assigments.classes;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Week9Task14BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUpBaseURL() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/api/v1/")
                .build();
    }
}
