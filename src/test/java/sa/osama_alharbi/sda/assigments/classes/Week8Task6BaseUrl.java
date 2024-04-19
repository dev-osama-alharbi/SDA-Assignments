package sa.osama_alharbi.sda.assigments.classes;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Week8Task6BaseUrl {

    protected RequestSpecification spec;
    @BeforeMethod
    protected void setUp(){
        spec= new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .setContentType(ContentType.JSON)
                .build();
    }
}
