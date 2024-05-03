package sa.osama_alharbi.sda.assigments.classes;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Week9Task13BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUpBaseURL() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setContentType(ContentType.JSON)
                .build();
    }
}
