package sa.osama_alharbi.sda.assigments.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Week5Task3Test extends Tests {
    /*
       Go to Amazon
       Scroll to the bottom of the page using a robot
       Click on the "Back to top" web element
       Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
       Use Actions to type "ClarusWay" in the search box and perform the search
    */
    
    @Test
    public void scrollTest() throws AWTException {
        // Go to Amazon or ebay
        bot.navigate("https://www.ebay.com/");

        // Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);

        // Click on the "Back to top" web element
        wait.until(d -> driver.findElement(By.cssSelector("button#gh-bt")).isDisplayed());
        driver.findElement(By.cssSelector("button#gh-bt")).click();

        // Click on the Amazon logo at the bottom of the page (in the footer) or ebay Stores link using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(d -> driver.findElement(By.xpath("//a[text()='Stores']")).isDisplayed());
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Stores']")));

        // Use Actions to type "ClarusWay" in the search box and perform the search
        new Actions(driver)
                .sendKeys(driver.findElement(By.cssSelector("input#gh-ac")), "ClarusWay", Keys.ENTER)
                .perform();
    }
}
