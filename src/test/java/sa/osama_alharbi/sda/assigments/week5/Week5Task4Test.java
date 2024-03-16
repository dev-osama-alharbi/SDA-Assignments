package sa.osama_alharbi.sda.assigments.week5;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

import java.util.Set;

public class Week5Task4Test extends Tests {
    /*
        Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
    */ 
    
    @Test
    public void cookiesTest(){
        //Go to URL: http://facebook.com
        bot.navigate("http://facebook.com");

        //getCookies,
        Set<Cookie> cookies = driver.manage().getCookies();

        //addCookie,
        driver.manage().addCookie(new Cookie("testKey","testValue"));

        //deleteCookieNamed,
        driver.manage().deleteCookieNamed("testKey");

        //deleteAllCookies
        driver.manage().deleteAllCookies();
    }
}
