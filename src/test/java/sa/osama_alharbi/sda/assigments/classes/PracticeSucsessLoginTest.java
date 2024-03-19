package sa.osama_alharbi.sda.assigments.classes;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;
import sa.osama_alharbi.sda.assigments.pages.login.LoginPage;
import sa.osama_alharbi.sda.assigments.pages.login.PracticeLoginPage;

public class PracticeSucsessLoginTest extends Tests {

    /**
     * Breakout task: 30 minute
     * - login by applying POM pattern -> https://practice.expandtesting.com/login
     * - generate working allure report
     * - optional: read data from json file
     */

    @Test
    public void secessLoginTest(){
        PracticeLoginPage loginPage = new PracticeLoginPage(bot,driver);
        loginPage.goTo();

        JSONObject saucedemoObject = (JSONObject) testData.get("practice");
        String username = (String) saucedemoObject.get("Username");
        String password = (String) saucedemoObject.get("Password");

        loginPage.login(username,password);

        Assert.assertEquals(bot.getText(By.tagName("h1")),"Secure Area");
    }
}
