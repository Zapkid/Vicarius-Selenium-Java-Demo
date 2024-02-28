package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends SignBase {

    @FindBy(css = "[id='input24']")
    private WebElement emailInput;

    @Step("Get Email field element")
    public WebElement getEmailInput() {
        return emailInput;
    }

    @FindBy(css = ".notification-content")
    private WebElement notificationContent;

    @Step("Get Notification content element")
    public WebElement getNotificationContent() {
        return notificationContent;
    }

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    @Step("Get Error message element")
    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(css = ".content .logo")
    private WebElement contentLogo;

    @Step("Get Content logo element")
    public WebElement getContentLogo() {
        return contentLogo;
    }

}