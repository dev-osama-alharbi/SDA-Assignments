package sa.osama_alharbi.sda.assigments.classes;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;
import sa.osama_alharbi.sda.assigments.pages.login.LoginPage;

public class SucsessLoginTest extends Tests {

    /**
     * Breakout task: 40 minute
     * - login page object model class
     * - one test method that uses this class
     * - optional: read data from json file
     * - optional: create two more test methods
     */

    @Test
    public void secessLoginTest(){
        LoginPage loginPage = new LoginPage(bot,driver);
        loginPage.goTo();

        JSONObject saucedemoObject = (JSONObject) testData.get("saucedemo");
        JSONObject standardUser = (JSONObject) saucedemoObject.get("standard_user");
        String username = (String) standardUser.get("Username");
        String password = (String) standardUser.get("Password");

        loginPage.login(username,password);

        Assert.assertEquals(bot.getText(By.className("product_label")),"Products");
    }

    @Test
    public void lockedOutUserLoginTest(){
        LoginPage loginPage = new LoginPage(bot,driver);
        loginPage.goTo();
        loginPage.login("locked_out_user","secret_sauce");

        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Epic sadface:"));
    }
}
