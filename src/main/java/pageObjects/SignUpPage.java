package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends SignBase {

    @FindBy(css = "[id='input27']")
    private WebElement first_name_input;

    @Step("Get First Name input element")
    public WebElement getFirstNameInput() {
        return first_name_input;
    }

    @FindBy(css = "[id='input29']")
    private WebElement last_name_input;

    @Step("Get Last Name input element")
    public WebElement getLastNameInput() {
        return last_name_input;
    }

    @FindBy(css = "[id='input31']")
    private WebElement email_input;

    @Step("Get Email input element")
    public WebElement getEmailInput() {
        return email_input;
    }

    @FindBy(css = "[id='input33']")
    private WebElement company_input;

    @Step("Get Last Name input element")
    public WebElement getCompanyInput() {
        return company_input;
    }

}