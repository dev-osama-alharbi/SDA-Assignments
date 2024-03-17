package sa.osama_alharbi.sda.assigments.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.CustomListeners;
import sa.osama_alharbi.sda.assigments.Tests;

//@Listeners(CustomListeners.class)
public class Week5Task1Test extends Tests {
    /*
        Go to URL: http://demo.guru99.com/test/drag_drop.html
        Drag and drop the BANK button to the Account section in DEBIT SIDE
        Drag and drop the SALES button to the Account section in CREDIT SIDE
        Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        Verify the visibility of Perfect text.
    */ 
    
    @Test
    public void dragAndDropTest(){
        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        bot.dragAndDrop(By.cssSelector("li.block14>a.button"),By.cssSelector("ol#bank"));

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        bot.dragAndDrop(By.cssSelector("li.block15>a.button"),By.cssSelector("ol#loan"));

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        bot.dragAndDrop(By.cssSelector("li.block13>a.button"),By.cssSelector("ol#amt7"));

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        bot.dragAndDrop(By.cssSelector("li.block13>a.button"),By.cssSelector("ol#amt8"));

        //Verify the visibility of Perfect text.
        String result = bot.getText(By.cssSelector("div.table4_result"));
        assert result.equals("Perfect!") : "the visibility of Perfect text Not show";

    }
}
