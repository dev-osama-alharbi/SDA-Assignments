package sa.osama_alharbi.sda.assigments.week6;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

public class Week6Task4Test extends Tests {
    /*✅
        //Open the site: http://opencart.abstracta.us/index.php?route=account/login
        //Login with that credentials
        //Email: clarusway@gmail.com
        //Password: 123456789
        //Using the Search function do it with Data Provider for Mac, iPad and Samsung.
     */
    @Test(dataProvider = "searchData")
    public void searchWithDataProviderTest(String[][] searchData){
        //Open the site: http://opencart.abstracta.us/index.php?route=account/login
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");

        //Login with that credentials
        //Email: clarusway@gmail.com
        //Password: 123456789
        bot.type(By.id("input-email"),"clarusway@gmail.com");
        bot.type(By.id("input-password"),"123456789");
        bot.click(By.xpath("//input[@type='submit']"));

        //Using the Search function do it with Data Provider for Mac, iPad and Samsung.
        for (String[] searchDatum : searchData) {
            bot.type(By.xpath("//input[@type='text']"),searchDatum[0]);
            bot.click(By.cssSelector("div#search>span>button"));
        }
    }
    @DataProvider
    private Object[][] searchData(){
        Object[][] objects = new Object[1][1];

        String[][] searchData = new String[3][1];
        searchData[0][0] = "Mac";
        searchData[1][0] = "iPad";
        searchData[2][0] = "Samsung";

        objects[0][0] = searchData;
        return objects;
    }
}
