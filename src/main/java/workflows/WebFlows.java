package workflows;

import utilities.CommonOps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import extensions.UIActions;
import extensions.Verifications;

public class WebFlows extends CommonOps {
    public static void signIn(String email) {
        UIActions.type(vicariusSignIn.getEmailInput(), email);
        LOG.info("Signing in user: " + email);
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton(), SLEEP_TIMEOUT);
    }

    public static void verifyCloseNotification() {
        Verifications.verifyElementIsVisible(vicariusSignIn.getNotificationClose());
        LOG.info("Closing login notification...");
        UIActions.click(vicariusSignIn.getNotificationClose(), 1_000);
        Verifications.verifyElementNotFound(".notification-content");
        LOG.info("Login notification closed successfully.");
    }

    public static void openChat() {
        UIActions.click(vicariusSignIn.getChatWidgetLauncher(), SLEEP_TIMEOUT);
        Verifications.verifyElementIsVisible(vicariusSignIn.getLiveChatWidget());
        LOG.info("Chat Widget opened successfully.");
    }

    public static void closeChat() {
        UIActions.click(vicariusSignIn.getChatWidgetLauncher(), SLEEP_TIMEOUT);
        Verifications.verifyElementNotFound("#live-chat-widget");
        LOG.info("Chat Widget closed successfully.");
    }
}
