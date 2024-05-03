package sa.osama_alharbi.sda.assigments.classes;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import sa.osama_alharbi.sda.assigments.utils.AuthenticationTask15;

public class Week9Task15BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUpBaseURL() {
        String auth = AuthenticationTask15.generateToken();
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com/")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer "+auth)
                .build();
    }
}
