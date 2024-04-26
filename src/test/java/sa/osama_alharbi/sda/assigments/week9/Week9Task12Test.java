package sa.osama_alharbi.sda.assigments.week9;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.classes.Week9Task12BaseUrl;
import sa.osama_alharbi.sda.assigments.pojo.PetModel;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Week9Task12Test extends Week9Task12BaseUrl {

    /*
        //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
        (All actions must be done on same pet)
        (Use Pojo)
     */

    @Test(priority = 0)
    public void createPetTest(){
        spec.pathParam("first", "pet");

        PetModel.Category category = new PetModel.Category(1, "Dogs");
        PetModel.Tag tag = new PetModel.Tag(1, "cute");
        PetModel pet = new PetModel(9223372036854775807L, category, "Doggie", Arrays.asList("http://example.com/photo"), Arrays.asList(tag), "available");

        Response createResponse = given(spec)
                .contentType(ContentType.JSON)
                .body(pet)
                .post("{first}");
        createResponse.prettyPrint();

        assertEquals(createResponse.getStatusCode(), 200);
    }

    @Test(priority = 1)
    public void getPetTest() {
        //set the url
        long petId = 9223372036854775807L;
        spec.pathParam("first", "pet");

        //set the expectedData

        //send the request and get the response
        Response readResponse = given(spec)
                .get("{first}/" + petId);
        readResponse.prettyPrint();


        PetModel actualPet = readResponse.as(PetModel.class);

        // Do assertion
        assertEquals(readResponse.getStatusCode(), 200);
        assertEquals(actualPet.getId(), petId);

    }

    @Test(priority = 2)
    public void updatePetTest() {
        // Set the url
        spec.pathParam("first", "pet");


        PetModel.Category category = new PetModel.Category(1, "Dogs");
        PetModel.Tag tag = new PetModel.Tag(1, "cute");
        PetModel pet = new PetModel(9223372036854775807L, category, "Doggie", Arrays.asList("http://example.com/photo"), Arrays.asList(tag), "available");

        //sent the request and get the response
        pet.setName("Updated Doggie");
        pet.getPhotoUrls().set(0, "http://example.com/updated-photo");
        Response updateResponse = given(spec)
                .contentType(ContentType.JSON)
                .body(pet)
                .put("{first}");
        updateResponse.prettyPrint();

        // do assertion
        assertEquals(updateResponse.getStatusCode(), 200);;


    }

    @Test(priority = 3)
    public void deletePetTest(){
        // Set the URL url
        spec.pathParam("first", "pet");

        //set the expectedData
        PetModel.Category category = new PetModel.Category(1, "Dogs");
        PetModel.Tag tag = new PetModel.Tag(1, "cute");
        PetModel pet = new PetModel(9223372036854775807L, category, "Doggie", Arrays.asList("http://example.com/photo"), Arrays.asList(tag), "available");


        // Delete the pet
        Response deleteResponse = given(spec)
                .delete("{first}/" + pet.getId());
        deleteResponse.prettyPrint();

        // Assert deletion success
        assertEquals(deleteResponse.getStatusCode(), 200);
    }
}
