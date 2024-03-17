package sa.osama_alharbi.sda.assigments;

import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener, WebDriverListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[onTestSuccess] "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[onTestFailure] "+result.getName());
    }


}
