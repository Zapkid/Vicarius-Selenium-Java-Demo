package pageObjects;

import io.qameta.allure.Step;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends SignBase {

    @FindBy(css = "[id='input27']")
    private WebElement firstNameInput;

    @Step("Get First Name input element")
    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    @FindBy(css = "[id='input29']")
    private WebElement lastNameInput;

    @Step("Get Last Name input element")
    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    @FindBy(css = "[id='input31']")
    private WebElement emailInput;

    @Step("Get Email input element")
    public WebElement getEmailInput() {
        return emailInput;
    }

    @FindBy(css = "[id='input33']")
    private WebElement companyInput;

    @Step("Get Company input element")
    public WebElement getCompanyInput() {
        return companyInput;
    }

    @FindBy(css = "[id='input64']")
    private WebElement passwordInput;

    @Step("Get Password input element")
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    @FindBy(css = "[id='input66']")
    private WebElement confirmPasswordInput;

    @Step("Get Confirm Password input element")
    public WebElement getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    @FindBy(css = ".consent-icon")
    private WebElement consentIcon;

    @Step("Get Consent Icon element")
    public WebElement getConsentIcon() {
        return consentIcon;
    }

    @FindBy(css = ".consent-text")
    private WebElement consentText;

    @Step("Get Consent Text element")
    public WebElement getConsentText() {
        return consentText;
    }

    @FindBy(css = ".password-help")
    private WebElement passwordHelp;

    @Step("Get Password Help element")
    public WebElement getPasswordHelp() {
        return passwordHelp;
    }

    @FindBy(css = ".password-help .label")
    private WebElement passwordHelpLabel;

    @Step("Get Password Help Label element")
    public WebElement getPasswordHelpLabel() {
        return passwordHelpLabel;
    }

    @FindBy(css = ".password-help .tag")
    private List<WebElement> passwordHelpRules;

    @Step("Get Password Help Rule element")
    public List<WebElement> getPasswordHelpRules() {
        return passwordHelpRules;
    }

    @FindBy(css = ".signup-form .msg")
    private WebElement messageIcon;

    @Step("Get Message Icon element")
    public WebElement getMessageIcon() {
        return messageIcon;
    }

}