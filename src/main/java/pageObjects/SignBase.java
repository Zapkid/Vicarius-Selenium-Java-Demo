package pageObjects;

import io.qameta.allure.Step;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignBase {

    @FindBy(css = ".header .left a")
    private WebElement logo;

    @Step("Get Logo link element")
    public WebElement getLogo() {
        return logo;
    }

    @FindBy(css = ".header .option .text")
    private WebElement headerOptionText;

    @Step("Get Header option text element")
    public WebElement getHeaderOptionText() {
        return headerOptionText;
    }

    @FindBy(css = ".header .option a")
    private WebElement headerOptionLink;

    @Step("Get Header option link element")
    public WebElement getHeaderOptionLink() {
        return headerOptionLink;
    }

    @FindBy(css = ".features li h3")
    private List<WebElement> featuresHeaders;

    @Step("Get Features headers elements")
    public List<WebElement> getFeaturesHeaders() {
        return featuresHeaders;
    }

    @FindBy(css = ".features li p")
    private List<WebElement> featuresTexts;

    @Step("Get Features text elements")
    public List<WebElement> getFeaturesTexts() {
        return featuresTexts;
    }

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @Step("Get Submit Button element")
    public WebElement getSubmitButton() {
        return submitButton;
    }

    @FindBy(css = ".content .heading")
    private WebElement contentHeading;

    @Step("Get Content heading element")
    public WebElement getContentHeading() {
        return contentHeading;
    }

}