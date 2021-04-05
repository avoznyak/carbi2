import app.AppConfig;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest
{
    @Test
    public void unknownLogin() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue("123456789012");
        app.loginPage.sendPassword.click();
        app.loginPage.error.shouldBe(Condition.visible);
        app.loginPage.error.shouldHave(Condition.text("User with this ID not exists"));
    }

    @Test
    public void knownLogin() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue("198734530");
        app.loginPage.sendPassword.click();
        app.loginPage.error.shouldNot(Condition.exist);
        app.loginPage.sendPassword.shouldBe(Condition.visible);
    }

    @Test
    public void nonDigitLogin() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue("a!@#$");
        app.loginPage.loginField.shouldHave(Condition.text(""));
        app.loginPage.sendPassword.shouldNot(Condition.enabled);
    }

    @Test
    public void oneDigitLogin() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue("2");
        app.loginPage.sendPassword.shouldBe(Condition.enabled);
    }

    @Test
    public void thirteenDigitLogin() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue("1234567890123");
        app.loginPage.sendPassword.shouldBe(Condition.enabled);
        app.loginPage.loginField.shouldHave(Condition.value("123456789012"));
    }

    @Test
    public void twelveDigitLogin() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue("123456789012");
        app.loginPage.sendPassword.shouldBe(Condition.enabled);
        app.loginPage.loginField.shouldHave(Condition.value("123456789012"));
    }

    @Test
    public void validLoginInvalidPassword() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue(AppConfig.validLogin);
        app.loginPage.sendPassword.click();
        app.loginPage.passwordField.setValue("1234");
        app.loginPage.loginBtn.click();
        app.loginPage.error.shouldHave(Condition.text("Wrong User ID or password"));
    }

    @Test
    public void resendPassword() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue(AppConfig.validLogin);
        app.loginPage.sendPassword.click();
        app.loginPage.resendBtn.click();
        app.loginPage.passwordField.shouldBe(Condition.visible);
    }

    @Test
    public void nonDigitPassword() throws InterruptedException {
        app.loginPage.open();
        app.loginPage.loginIcon.click();
        app.loginPage.loginField.setValue(AppConfig.validLogin);
        app.loginPage.sendPassword.click();
        app.loginPage.passwordField.setValue("q*");
        app.loginPage.passwordField.shouldHave(Condition.value(""));

    }





}
