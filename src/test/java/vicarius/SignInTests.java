package vicarius;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class SignInTests extends CommonOps {

    @BeforeClass
    public void startSession() {
        browserName = "chrome";
        url = "https://www.vicarius.io/sign/in";
        timeout = Duration.ofSeconds(10);

        initWeb();
    }

    @Test(description = "Sign in page logo")
    @Description("Logo visible on Sign In page")
    public void Test01_VicariusLogoVisible() {
        Verifications.verifyElementIsVisible(vicariusSignIn.getLogo());
    }

    @Test(description = "Sign in page option")
    @Description("Option visible on Sign In page")
    public void Test02_VicariusOption() {
        Verifications.verifyElementIsVisible(vicariusSignIn.getHeaderOptionText());
        Verifications.verifyElementText(vicariusSignIn.getHeaderOptionText(), "Don't have an account?");
        Verifications.verifyElementIsVisible(vicariusSignIn.getHeaderOptionLink());
        Verifications.verifyElementText(vicariusSignIn.getHeaderOptionLink(), "Start Free Trial");
        Verifications.verifyString(vicariusSignIn.getHeaderOptionLink().getAttribute("href"), "https://www.vicarius.io/sign/up");
    }

    @Test(description = "Sign in page features")
    @Description("Features visible on Sign In page")
    public void Test03_VicariusFeatures() {
        // TODO - Load texts from csv file
        String[][] features = { { "Vuln Discovery", "You can’t fix what you can’t find." },
                { "Vuln Prioritization", "Focus on risks that have real potential for exploitation" },
                { "Vuln Remediation", "Don’t just find your flaws, fix them." },
                { "Automation", "Threats don’t take time off, but you can." } };

        Verifications.verifyNumberOfElements(vicariusSignIn.getFeaturesHeaders(), features.length);
        Verifications.verifyNumberOfElements(vicariusSignIn.getFeaturesTexts(), features.length);

        for (WebElement element : vicariusSignIn.getFeaturesHeaders()) {
            Verifications.verifyElementIsVisible(element);
        }
        for (WebElement element : vicariusSignIn.getFeaturesTexts()) {
            Verifications.verifyElementIsVisible(element);
        }

        for (int i = 0; i < features.length; i++) {
            assertEquals(vicariusSignIn.getFeaturesHeaders().get(i).getText(), features[i][0]);
            assertEquals(vicariusSignIn.getFeaturesTexts().get(i).getText(), features[i][1]);
        }
    }

    @Test(description = "Valid Sign in")
    @Description("Valid Sign In")
    public void Test04_VicariusValidSignIn() {
        UIActions.noWaitSendKeys(vicariusSignIn.getEmailInput(), "admin@vicarius.io");
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton());
        Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                "If the email address exists and is active, further instructions have been sent to your email address.");

        Verifications.verifyResponseStatus("https://www.vicarius.io/api/v2/forms/signin", "200");

    }

    @Test(description = "Sign in - Email not found")
    @Description("Email not found Sign In")
    public void Test05_VicariusMissingEmailSignIn() {
        UIActions.noWaitSendKeys(vicariusSignIn.getEmailInput(), "qa.test@victorius.io");
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton());
        Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                "If the email address exists and is active, further instructions have been sent to your email address.");

        Verifications.verifyResponseStatus("https://www.vicarius.io/api/v2/forms/signin", "400");

    }

    @Test(description = "Invalid Sign in")
    @Description("Invalid Email Sign In")
    public void Test06_VicariusInvalidSignIn() {
        UIActions.noWaitSendKeys(vicariusSignIn.getEmailInput(), "sum.ting.wong");
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton());
        Verifications.verifyStringContains(vicariusSignIn.getErrorMessage().getText(),
                "Invalid email address");
        Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                "Please, verify if all fields are correctly filled.");

    }

    @Test(description = "Empty Sign in")
    @Description("Empty Email Sign In")
    public void Test07_VicariusEmptySignIn() {
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton());
        Verifications.verifyStringContains(vicariusSignIn.getErrorMessage().getText(),
                "Invalid email address");
        Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                "Please, verify if all fields are correctly filled.");

    }
}
