package sa.osama_alharbi.sda.assigments.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

public class Week5Task2Test extends Tests {
    /** ( This task should be managed with keyboard actions ) */
    // go to https://www.google.com/
    // search for "Scroll Methods" by using an Actions objec
    
    @Test
    public void searchScrollMethodsUsingKeyboardTest(){
        /** ( This task should be managed with keyboard actions ) */
        // go to https://www.google.com/
        bot.navigate("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions objec
        new Actions(driver)
                .sendKeys(driver.findElement(By.id("APjFqb")), "Scroll Methods", Keys.RETURN)
                .perform();

        assert driver.getCurrentUrl().startsWith("https://www.google.com/search?") : "not able to search by using an Actions";
    }
}
