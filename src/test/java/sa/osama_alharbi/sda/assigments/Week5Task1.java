package sa.osama_alharbi.sda.assigments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Week5Task1 extends Tests{
    /*
        Go to URL: http://demo.guru99.com/test/drag_drop.html
        Drag and drop the BANK button to the Account section in DEBIT SIDE
        Drag and drop the SALES button to the Account section in CREDIT SIDE
        Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        Verify the visibility of Perfect text.
    */ 
    
    @Test
    public void test(){
        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        By bankBtn = By.cssSelector("li.block14>a.button");
        WebElement bankBtnElement = driver.findElement(bankBtn);
        By bankOl = By.cssSelector("ol#bank");
        WebElement bankOlElement = driver.findElement(bankOl);

        new Actions(driver)
                .dragAndDrop(bankBtnElement,bankOlElement)
                .build()
                .perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        By salesBtn = By.cssSelector("li.block15>a.button");
        WebElement salesBtnElement = driver.findElement(salesBtn);
        By salesOl = By.cssSelector("ol#loan");
        WebElement salesOlElement = driver.findElement(salesOl);

        new Actions(driver)
                .dragAndDrop(salesBtnElement,salesOlElement)
                .build()
                .perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        By s1Btn = By.cssSelector("li.block13>a.button");
        WebElement s1BtnElement = driver.findElements(s1Btn).get(1);
        By s1Ol = By.cssSelector("ol#amt7");
        WebElement s1OlElement = driver.findElement(s1Ol);

        new Actions(driver)
                .dragAndDrop(s1BtnElement,s1OlElement)
                .build()
                .perform();

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        By s2Btn = By.cssSelector("li.block13>a.button");
        WebElement s2BtnElement = driver.findElements(s2Btn).get(1);
        By s2Ol = By.cssSelector("ol#amt8");
        WebElement s2OlElement = driver.findElement(s2Ol);

        new Actions(driver)
                .dragAndDrop(s2BtnElement,s2OlElement)
                .build()
                .perform();

        //Verify the visibility of Perfect text.
        By resultTxt = By.cssSelector("div.table4_result");
        WebElement resultTxtElement = driver.findElement(resultTxt);
        assert resultTxtElement.getText().equals("Perfect!") : "the visibility of Perfect text Not show";

    }
}
