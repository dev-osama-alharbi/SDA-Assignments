package sa.osama_alharbi.sda.assigments.classes;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Task2BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/")
                .setContentType(ContentType.JSON)
                .build();

    }
}
