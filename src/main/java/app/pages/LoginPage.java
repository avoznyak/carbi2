package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public SelenideElement loginIcon = $(By.xpath("//i[contains(@class, 'fa')]"));
    public SelenideElement loginField = $(By.xpath("//input[contains(@aria-label,'Username')]"));
    public SelenideElement passwordField = $(By.xpath("//input[contains(@type,'password')]"));
    public SelenideElement sendPassword = $(By.xpath("//button[contains(text(), 'Send Password')]"));
    public SelenideElement loginBtn = $(By.xpath("//button[contains(text(), 'Log In')]"));
    public SelenideElement resendBtn = $(By.xpath("//button[contains(text(), 'Re-Send')]"));
    public SelenideElement error = $(By.xpath("//span[contains(@data-testid, 'errorMessage')]"));
    public LoginPage(String pageUrl) {
        super(pageUrl);
    }



}
