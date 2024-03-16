package sa.osama_alharbi.sda.assigments.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

import java.io.File;
import java.io.IOException;

public class Week5Task6Test extends Tests {
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    
    @Test
    public void screenshotTests() throws IOException {
        // Go to amazon.com
        bot.navigate("https://www.amazon.sa");

        // Take Full Page Screenshot.
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fullPageScreenshot, new File("target/fullPageScreenshot.png"));

        // Take any spesific WebElement ScreenShot
        File elementScreenshot = driver.findElement(By.cssSelector("div#nav-belt")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(elementScreenshot,new File("target/elementScreenshot.png"));
    
    }
}
