import extensions.UIActions;
import extensions.Verifications;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class SignInPageTests extends CommonOps {

        /**
         * Tests a valid sign in flow.
         * Calls the signIn() workflow with valid credentials.
         * Verifies the notification text, submit button state,
         * and API response after sign in.
         */
        @Test(description = "Valid Sign in", priority = 1)
        @Description("Tests a valid sign in flow with valid credentials. Verifies the notification text, submit button state, and API response after sign in.")
        public void VicariusValidSignIn() {

                WebFlows.signIn(VALID_EMAIL);

                Verifications.verifySignIn(HttpResponseStatus.OK);

        }

        // Note: Can easily be split into multiple tests - kept in one test since no
        // functionality is being tested.
        @Test(description = "Sign in page elements visibility, text & style", priority = 3)
        @Description("Elements visible on Sign In page")
        public void VicariusUIVisible() {

                // Verify Right & Left col elements
                Verifications.verifyElementIsVisible(vicariusSignIn.getRightSide());
                Verifications.verifyElementIsVisible(vicariusSignIn.getLeftSide());
                Verifications.verifyElementCss(vicariusSignIn.getLeftSide().findElement(By.cssSelector(".bg")),
                                "background",
                                "rgba(0, 0, 0, 0) linear-gradient(288.57deg, rgb(222, 33, 253) -9.08%, rgb(122, 17, 255) 74.09%) repeat scroll 0% 0% / auto padding-box border-box");

                // Verify Logos
                Verifications.verifyElementIsVisible(vicariusSignIn.getLogo());
                Verifications.verifyElementIsVisible(vicariusSignIn.getLoginLogo());

                // Verify Heading & Subtitle texts
                Verifications.verifyElementText(vicariusSignIn.getContentHeading(), "Welcome Back!");
                Verifications.verifyElementText(vicariusSignIn.getContentSubtitle(), "Please enter your e-mail below.");

                // Verify Forgot email link
                Verifications.verifyElementText(vicariusSignIn.getForgotEmailLink(), "Forgot my e-mail");
                Verifications.verifyString(vicariusSignIn.getForgotEmailLink().getAttribute("href"),
                                "mailto:" + SUPPORT_EMAIL);

                // Verify Email input initial background-color
                Verifications.verifyElementCss(getElementParent(vicariusSignIn.getEmailInput()), "background-color",
                                INPUT_COLOR);

                // Verify login button enabled & text
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), true);
                Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");

        }

        @Test(description = "Sign in page option", priority = 2)
        @Description("Option visible on Sign In page")
        public void VicariusOption() {

                // Verify header option text & link
                Verifications.verifyElementText(vicariusSignIn.getHeaderOptionText(), "Don't have an account?");
                Verifications.verifyElementText(vicariusSignIn.getHeaderOptionLink(), "Start Free Trial");
                Verifications.verifyString(vicariusSignIn.getHeaderOptionLink().getAttribute("href"),
                                SIGN_UP_URL);

                // Trigger hover effect
                UIActions.hover(vicariusSignIn.getHeaderOptionLink());
                // TODO - Add assertion on header option link hover effect
        }

        @Test(description = "Sign in page features & FAQ", priority = 3)
        @Description("Features & FAQ visible on Sign In page")
        public void VicariusFeaturesAndFAQ() {

                // Verify features icons & texts visibility
                Verifications.verifyElementsAmountAndVisibility(vicariusSignIn.getFeaturesIcons(), features.length);
                Verifications.verifyElementsAmountAndVisibility(vicariusSignIn.getFeaturesHeaders(), features.length);
                Verifications.verifyElementsAmountAndVisibility(vicariusSignIn.getFeaturesTexts(), features.length);

                for (int i = 0; i < features.length; i++) {
                        WebElement featureIcon = vicariusSignIn.getFeaturesIcons().get(i);
                        WebElement featureHeader = vicariusSignIn.getFeaturesHeaders().get(i);
                        WebElement featureText = vicariusSignIn.getFeaturesTexts().get(i);

                        // Verify icon width & height
                        Verifications.verifyString(featureIcon.getAttribute("width"), "80");
                        Verifications.verifyString(featureIcon.getAttribute("height"), "80");

                        // Verify feature texts
                        Verifications.verifyString(featureHeader.getText(), features[i][0]);
                        Verifications.verifyString(featureText.getText(), features[i][1]);
                }

                // Verify FAQ link
                Verifications.verifyElementText(vicariusSignIn.getFrequentlyAskedQuestionsLink(),
                                "Frequently Asked Questions →");
                Verifications.verifyString(vicariusSignIn.getFrequentlyAskedQuestionsLink().getAttribute("href"),
                                CUSTOMER_PORTAL_URL + "/");
        }

        @Test(description = "Email not found Sign In", priority = 2)
        @Description("Valid unrecognized email Sign in - Invalid email address API response")
        public void VicariusMissingEmailSignIn() {

                WebFlows.signIn("qa.test@victorius.io");

                Verifications.verifySignIn(HttpResponseStatus.BAD_REQUEST,
                                "Invalid email address");

        }

        // TODO - Merge with Empty sign in test - Use DDT with data-provider
        // TODO - Add test to verify notification disappears on its own
        @Test(description = "Invalid Email Sign in", priority = 2)
        @Description("Invalid Email Sign In errors & Input background color turns red")
        public void VicariusInvalidSignIn() {

                WebFlows.signIn("sum.ting.wong");

                // Verify sign in error & notification texts
                Verifications.verifySignInErrorAndNotificationTexts();

                // Verify login button enabled
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), true);

                // Verify notification closes on close
                WebFlows.verifyCloseNotification();

                // Verify error link
                Verifications.verifyElementText(vicariusSignIn.getErrorMessageLink(),
                                "Get a Free Trial");
                Verifications.verifyString(vicariusSignIn.getErrorMessageLink().getAttribute("href"),
                                SIGN_UP_URL);

                // Verify email input background-color changed to red
                Verifications.verifyElementCss(getElementParent(vicariusSignIn.getEmailInput()),
                                "background-color",
                                ERROR_RED_COLOR);
        }

        @Test(description = "Empty Sign in", priority = 2)
        @Description("Verify Empty Email Sign In errors & Input background color turns red")
        public void VicariusEmptySignIn() {

                WebFlows.signIn("");

                // Verify sign in error & notification texts
                Verifications.verifySignInErrorAndNotificationTexts();

                // Verify login button enabled
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), true);

                WebFlows.verifyCloseNotification();

                // Verify error link
                Verifications.verifyElementText(vicariusSignIn.getErrorMessageLink(),
                                "Get a Free Trial");
                Verifications.verifyString(vicariusSignIn.getErrorMessageLink().getAttribute("href"),
                                SIGN_UP_URL);

                // Verify email input background-color changed to red
                Verifications.verifyElementCss(getElementParent(vicariusSignIn.getEmailInput()),
                                "background-color",
                                ERROR_RED_COLOR);
        }

}
