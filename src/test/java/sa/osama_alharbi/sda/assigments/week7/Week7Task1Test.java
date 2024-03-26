package sa.osama_alharbi.sda.assigments.week7;

import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;
import sa.osama_alharbi.sda.assigments.pages.lambdatest.LambdaTestRegisterPage;

public class Week7Task1Test extends Tests {
    /*
      go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
      register account test with fluent page object approach
    */

    @Test
    public void registerLambdatestTest(){
        new LambdaTestRegisterPage(bot)
                .goTo()
                .register("Osama","AL-Harbi","osama@osama1.net","0123456789","123q123")
                .assertRegister();
    }
}
