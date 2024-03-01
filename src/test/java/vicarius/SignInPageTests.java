package vicarius;

import extensions.UIActions;
import extensions.Verifications;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class SignInPageTests extends CommonOps {

        // TODO - Move to CommonOps & Extract to @Parameters & xml file
        @BeforeClass
        public void startSession() {
                browserName = "chrome";
                url = "https://www.vicarius.io/sign/in";
                timeout = Duration.ofSeconds(5);

                initWeb();
        }

        // TODO - Extract all hard-coded values to json test data file

        /**
         * Tests a valid sign in flow.
         * Calls the signIn() workflow with valid credentials.
         * Verifies the notification text, submit button state,
         * and API response after sign in.
         */
        @Test(description = "Valid Sign in", priority = 1)
        @Description("Valid Sign In flow, API response success status code 200 OK")
        public void VicariusValidSignIn() {

                WebFlows.signIn(VALID_EMAIL);

                // Verify notification text
                Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                                "If the email address exists and is active, further instructions have been sent to your email address.");

                // Verify login button disabled
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), false);

                // Verify sign in API response
                Verifications.verifyApiResponse(API_SIGN_IN_URL, HttpResponseStatus.OK);
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
                                "mailto:support@vicarius.io");

                // Verify Email input initial background-color
                Verifications.verifyElementCss(vicariusSignIn.getEmailInput().findElement(By.xpath("parent::*")),
                                "background-color",
                                "rgba(76, 78, 240, 0.2)");
        }

        @Test(description = "Sign in page option", priority = 2)
        @Description("Option visible on Sign In page")
        public void VicariusOption() {

                // Verify header option text & link
                Verifications.verifyElementText(vicariusSignIn.getHeaderOptionText(), "Don't have an account?");
                Verifications.verifyElementText(vicariusSignIn.getHeaderOptionLink(), "Start Free Trial");
                Verifications.verifyString(vicariusSignIn.getHeaderOptionLink().getAttribute("href"),
                                "https://www.vicarius.io/sign/up");

                // Trigger hover effect
                UIActions.mouseHover(vicariusSignIn.getHeaderOptionLink());
                // TODO - Add assertion on header option link hover effect
        }

        @Test(description = "Sign in page features & faq", priority = 3)
        @Description("Features & faq visible on Sign In page")
        public void VicariusFeatures() {
                // TODO - Load texts from csv or json file
                String[][] features = { { "Vuln Discovery", "You can’t fix what you can’t find." },
                                { "Vuln Prioritization", "Focus on risks that have real potential for exploitation" },
                                { "Vuln Remediation", "Don’t just find your flaws, fix them." },
                                { "Automation", "Threats don’t take time off, but you can." } };

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

                // Verify faq link
                Verifications.verifyElementText(vicariusSignIn.getFrequentlyAskedQuestionsLink(),
                                "Frequently Asked Questions →");
                Verifications.verifyString(vicariusSignIn.getFrequentlyAskedQuestionsLink().getAttribute("href"),
                                "https://customer-portal.vicarius.io/");
        }

        @Test(description = "Email not found Sign In", priority = 2)
        @Description("Valid unrecognized email Sign in - Invalid email address API response")
        public void VicariusMissingEmailSignIn() {
                WebFlows.signIn("qa.test@victorius.io");

                // Verify notification text
                Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                                "If the email address exists and is active, further instructions have been sent to your email address.");

                // Verify login button disabled
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), false);

                // Verify sign in API response
                Verifications.verifyApiResponse(API_SIGN_IN_URL, HttpResponseStatus.BAD_REQUEST,
                                "Invalid email address");
        }

        // TODO - Merge with Empty sign in test - Use DDT with data-provider
        @Test(description = "Invalid Email Sign in", priority = 2)
        @Description("Invalid Email Sign In errors & Input background color turns red")
        public void VicariusInvalidSignIn() {

                WebFlows.signIn("sum.ting.wong");

                // Verify sign in error & notification texts
                Verifications.verifyStringContains(vicariusSignIn.getErrorMessage().getText(),
                                "Invalid email address");
                Verifications.verifyElementText(vicariusSignIn.getNotificationTitle(),
                                "Validation failed");
                Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                                "Please, verify if all fields are correctly filled.");

                // Verify login button enabled
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), true);

                // TODO - Add test to verify notification disappears on its own
                // Verify notification closes on close
                Verifications.verifyElementIsVisible(vicariusSignIn.getNotificationClose());
                UIActions.click(vicariusSignIn.getNotificationClose(), 1_000);
                Verifications.verifyElementNotFound(".notification-content");

                // Verify error link
                Verifications.verifyElementText(vicariusSignIn.getErrorMessageLink(),
                                "Get a Free Trial");
                Verifications.verifyString(vicariusSignIn.getErrorMessageLink().getAttribute("href"),
                                "https://www.vicarius.io/sign/up");

                // Verify email input background-color changed to red
                Verifications.verifyElementCss(vicariusSignIn.getEmailInput().findElement(By.xpath("parent::*")),
                                "background-color",
                                "rgba(255, 104, 114, 0.15)");
        }

        @Test(description = "Empty Sign in", priority = 2)
        @Description("Verify Empty Email Sign In errors & Input background color turns red")
        public void VicariusEmptySignIn() {
                WebFlows.signIn("");

                // Verify sign in error & notification texts
                Verifications.verifyStringContains(vicariusSignIn.getErrorMessage().getText(),
                                "Invalid email address");
                Verifications.verifyElementText(vicariusSignIn.getNotificationTitle(),
                                "Validation failed");
                Verifications.verifyElementText(vicariusSignIn.getNotificationContent(),
                                "Please, verify if all fields are correctly filled.");

                // Verify login button enabled
                Verifications.verifyBoolean(vicariusSignIn.getSubmitButton().isEnabled(), true);

                // TODO - Add test to verify notification disappears on its own
                // Verify notification closes on close
                Verifications.verifyElementIsVisible(vicariusSignIn.getNotificationClose());
                UIActions.click(vicariusSignIn.getNotificationClose(), 1_000);
                Verifications.verifyElementNotFound(".notification-content");

                // Verify error link
                Verifications.verifyElementText(vicariusSignIn.getErrorMessageLink(),
                                "Get a Free Trial");
                Verifications.verifyString(vicariusSignIn.getErrorMessageLink().getAttribute("href"),
                                "https://www.vicarius.io/sign/up");

                // Verify email input background-color changed to red
                Verifications.verifyElementCss(vicariusSignIn.getEmailInput().findElement(By.xpath("parent::*")),
                                "background-color",
                                "rgba(255, 104, 114, 0.15)");
        }

        // Note - This test only showcases the use of mouse hover on two different
        // points in order to assert the cursor style has changed. It does not cover the
        // entire UX of the feature.
        @Test(description = "Mouse Cursor style", priority = 4)
        @Description("Verify Mouse Cursor style effect")
        public void VicariusMouseCursor() {

                // Move mouse to point A - causes style transform change
                UIActions.mouseHover(vicariusSignIn.getContentHeading(), SLEEP_TIMEOUT);
                String pointA = vicariusSignIn.getCursor().getAttribute("style");

                // Move mouse to point B - causes style transform change
                UIActions.mouseHover(vicariusSignIn.getLogo(), SLEEP_TIMEOUT);
                String pointB = vicariusSignIn.getCursor().getAttribute("style");

                // Verify cursor style has changed
                Verifications.verifyBoolean(pointA.equals(pointB), false);
        }

        @Test(description = "Chat Widget", priority = 4)
        @Description("Verify Chat Widget opens")
        public void VicariusChatWidget() {

                // Switch to chat widget iframe
                WebElement iframe = driver.findElement(By.cssSelector("iframe[id='hubspot-conversations-iframe']"));
                Verifications.verifyElementIsVisible(iframe);
                driver.switchTo().frame(iframe);

                // Open & close chat
                Verifications.verifyElementIsVisible(vicariusSignIn.getChatWidgetLauncher());
                UIActions.click(vicariusSignIn.getChatWidgetLauncher(), SLEEP_TIMEOUT);
                Verifications.verifyElementIsVisible(vicariusSignIn.getLiveChatWidget());
                UIActions.click(vicariusSignIn.getChatWidgetLauncher(), SLEEP_TIMEOUT);
                Verifications.verifyElementNotFound("#live-chat-widget");
        }

}
