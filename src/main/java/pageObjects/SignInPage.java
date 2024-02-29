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

    @FindBy(css = ".notification-title")
    private WebElement notificationTitle;

    @Step("Get Notification title element")
    public WebElement getNotificationTitle() {
        return notificationTitle;
    }

    @FindBy(css = ".notification-content")
    private WebElement notificationContent;

    @Step("Get Notification content element")
    public WebElement getNotificationContent() {
        return notificationContent;
    }

    @FindBy(css = ".notification-close")
    private WebElement notificationClose;

    @Step("Get Notification close element")
    public WebElement getNotificationClose() {
        return notificationClose;
    }

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    @Step("Get Error message element")
    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(css = ".error-message a")
    private WebElement errorMessageLink;

    @Step("Get Error message element")
    public WebElement getErrorMessageLink() {
        return errorMessageLink;
    }

    @FindBy(css = ".login .logo")
    private WebElement loginLogo;

    @Step("Get Login logo element")
    public WebElement getLoginLogo() {
        return loginLogo;
    }

    @FindBy(css = ".forgot")
    private WebElement forgotEmailLink;

    @Step("Get Forgot Email Link element")
    public WebElement getForgotEmailLink() {
        return forgotEmailLink;
    }

}