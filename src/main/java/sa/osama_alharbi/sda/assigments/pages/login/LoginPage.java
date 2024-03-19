package sa.osama_alharbi.sda.assigments.pages.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sa.osama_alharbi.sda.assigments.ActionsBot;

public class LoginPage {
    private ActionsBot bot;
    private WebDriver driver;
    private String url = "https://www.saucedemo.com/v1/index.html";

    public LoginPage(ActionsBot bot, WebDriver driver) {
        this.bot = bot;
        this.driver = driver;
    }

    @Step
    public void goTo(){
        this.bot.navigate(url);
    }

    @Step
    public void login(String username, String password){
        bot.type(By.xpath("//input[@id='user-name']"),username);
        bot.type(By.xpath("//input[@id='password']"),password);
        bot.click(By.xpath("//input[@id='login-button']"));
    }



}
