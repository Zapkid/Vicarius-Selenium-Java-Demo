package workflows;

import utilities.CommonOps;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;

public class WebFlows extends CommonOps {

    @Step("Business flow: Sign in")
    public static void signIn(String email) {
        UIActions.type(vicariusSignIn.getEmailInput(), email);
        LOG.info("Signing in user: " + email);
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton(), SLEEP_TIMEOUT);
    }

    @Step("Business flow: Sign up")
    public static void signUp(String firstName, String lastName, String email, String company) {
        UIActions.type(vicariusSignUp.getFirstNameInput(), firstName);
        UIActions.type(vicariusSignUp.getLastNameInput(), lastName);
        UIActions.type(vicariusSignUp.getEmailInput(), email);
        UIActions.type(vicariusSignUp.getCompanyInput(), company);
        LOG.info("Signing up user: Name: " + firstName + " " + lastName + ", Email: " + email + ", Company: " + company);

        UIActions.click(vicariusSignUp.getSubmitButton(), SLEEP_TIMEOUT);

        Verifications.verifyStringContains(vicariusSignUp.getContentHeading().getText().replaceAll("  ", " "),
                "Let’s Get Started!");
    }

    @Step("Business flow: Close Notification")
    public static void verifyCloseNotification() {
        Verifications.verifyElementIsVisible(vicariusSignIn.getNotificationClose());
        LOG.info("Closing login notification...");
        UIActions.click(vicariusSignIn.getNotificationClose(), 1_000);
        Verifications.verifyElementNotFound(".notification-content");
        LOG.info("Login notification closed successfully.");
    }

    @Step("Business flow: Open Chat")
    public static void openChat() {
        UIActions.click(vicariusSignIn.getChatWidgetLauncher(), SLEEP_TIMEOUT);
        Verifications.verifyElementIsVisible(vicariusSignIn.getLiveChatWidget());
        LOG.info("Chat Widget opened successfully.");
    }

    @Step("Business flow: Close Chat")
    public static void closeChat() {
        UIActions.click(vicariusSignIn.getChatWidgetLauncher(), SLEEP_TIMEOUT);
        Verifications.verifyElementNotFound("#live-chat-widget");
        LOG.info("Chat Widget closed successfully.");
    }
}
