package vicarius;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
// import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.CommonOps;

@Listeners(utilities.Listeners.class)
public class SignInPage extends CommonOps {

    @Test(description = "Sign in page logo")
    @Description("Logo visible on Sign In page")
    public void Test01_VicariusLogoVisible() {
        Verifications.verifyElementIsVisible(vicariusSignIn.getLogo());
        Verifications.verifyElementIsVisible(vicariusSignIn.getHeaderOptionText());
        Verifications.verifyElementIsVisible(vicariusSignIn.getHeaderOptionLink());
        Verifications.verifyNumberOfElements(vicariusSignIn.getFeaturesHeaders(), 4);

    }

    @Test(description = "Sign in")
    @Description("Sign In")
    public void Test02_VicariusSignIn() {
        UIActions.noWaitSendKeys(vicariusSignIn.getEmailInput(), "admin@vicarius.io");
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton());
        wait.until(ExpectedConditions.visibilityOf(vicariusSignIn.getNotificationContent()));
        Verifications.verifyElementText(vicariusSignIn.getNotificationContent(), "If the email address exists and is active, further instructions have been sent to your email address.");


    }

}
