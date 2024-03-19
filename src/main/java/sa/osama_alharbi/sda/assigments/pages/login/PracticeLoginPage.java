package sa.osama_alharbi.sda.assigments.pages.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sa.osama_alharbi.sda.assigments.ActionsBot;

public class PracticeLoginPage {
    private ActionsBot bot;
    private WebDriver driver;
    private String url = "https://practice.expandtesting.com/login";

    public PracticeLoginPage(ActionsBot bot, WebDriver driver) {
        this.bot = bot;
        this.driver = driver;
    }

    @Step
    public void goTo(){
        this.bot.navigate(url);
    }

    @Step
    public void login(String username, String password){
        bot.type(By.id("username"),username);
        bot.type(By.id("password"),password);
        bot.click(By.xpath("//button[@type='submit']"));
    }



}
