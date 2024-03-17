package sa.osama_alharbi.sda.assigments.week6;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

//@Listeners(CustomListeners.class)
public class Week6Task1Test extends Tests {
    /*
        Create tests that depend on each other
        Create beforeClass and set up settings.
        By creating interdependent tests;
        First go to Facebook.
        Then go to Google depending on Facebook,
        Then go to Amazon depending on Google
        Close the driver.
     */
    @Test
    public void navigateFacebookTest(){
        bot.navigate("https://www.facebook.com/");
    }
    @Test(dependsOnMethods = "navigateFacebookTest")
    public void navigateGoogleTest(){
        bot.navigate("https://www.google.com/");
    }
    @Test(dependsOnMethods = "navigateGoogleTest")
    public void navigateAmazonTest(){
        bot.navigate("https://www.amazon.sa/");
    }
}
