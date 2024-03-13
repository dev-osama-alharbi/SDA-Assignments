package sa.osama_alharbi.sda.assigments;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class Week5Task4 extends Tests{
    /*
        Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
    */ 
    
    @Test
    public void test(){
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
