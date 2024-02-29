package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class BasePage {

    @FindBy(css = ".cursor")
    private WebElement cursor;

    @Step("Get Cursor element")
    public WebElement getCursor() {
        return cursor;
    }

    @FindBy(css = "[data-test-id='chat-widget-launcher']")
    private WebElement chatWidgetLauncher;

    @Step("Get Chat Widget Launcher element")
    public WebElement getChatWidgetLauncher() {
        return chatWidgetLauncher;
    }

    @FindBy(css = "#live-chat-widget")
    private WebElement liveChatWidget;

    @Step("Get Live Chat Widget element")
    public WebElement getLiveChatWidget() {
        return liveChatWidget;
    }
}