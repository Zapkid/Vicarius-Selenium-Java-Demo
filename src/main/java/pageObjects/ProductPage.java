package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = "#live-chat-widget")
    private WebElement liveChatWidget;

    @Step("Get Live Chat Widget element")
    public WebElement getLiveChatWidget() {
        return liveChatWidget;
    }

}