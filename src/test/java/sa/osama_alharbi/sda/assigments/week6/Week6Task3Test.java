package sa.osama_alharbi.sda.assigments.week6;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sa.osama_alharbi.sda.assigments.Tests;

public class Week6Task3Test extends Tests {
    /*
        go to "https://practicetestautomation.com/practice-test-login/"
        enter username - "student"
        enter password - "incorrectPassword"
        and login
        SOFT ASSERT the error message shown
        SOFT ASSERT the error message is "Your password is invalid!"
     */
    @Test
    public void assertPasswordTest(){
        //go to "https://practicetestautomation.com/practice-test-login/"
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        //enter username - "student"
        bot.type(By.id("username"),"student");
        //enter password - "incorrectPassword"
        bot.type(By.id("password"),"incorrectPassword");

        //and login
        bot.click(By.id("submit"));

        //SOFT ASSERT the error message shown
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        softAssert.assertAll();

        //SOFT ASSERT the error message is "Your password is invalid!"
        SoftAssert softAssertMessage = new SoftAssert();
        softAssertMessage.assertEquals(bot.getText(By.id("error")),"Your password is invalid!");
        softAssertMessage.assertAll();
    }
}
