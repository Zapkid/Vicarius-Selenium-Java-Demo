package vicarius;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class SignUpPageTests extends CommonOps {

        // TODO - Move to CommonOps & Extract to @Parameters & xml file
        @BeforeClass
        public void startSession() {
                browserName = "chrome";
                url = SIGN_UP_URL;

                initWeb();
        }

        // TODO - Extract all hard-coded values to json test data file

        @Test(description = "Valid Sign up", priority = 1)
        @Description("Tests a valid sign up")
        public void VicariusValidSignUp() {

                // WebFlows.signUp(VALID_EMAIL);

                // Verifications.verifySignIn(HttpResponseStatus.OK);

        }

        // Note: Can easily be split into multiple tests - kept in one test since no
        // functionality is being tested.
        @Test(description = "Sign up page elements visibility, text & style", priority = 3)
        @Description("Elements visible on Sign Up page")
        public void VicariusUIVisible() {

                // Verify Right & Left col elements
                Verifications.verifyElementIsVisible(vicariusSignUp.getRightSide());
                Verifications.verifyElementIsVisible(vicariusSignUp.getLeftSide());
                Verifications.verifyElementCss(vicariusSignUp.getLeftSide().findElement(By.cssSelector(".bg")),
                                "background",
                                "rgba(0, 0, 0, 0) linear-gradient(288.57deg, rgb(222, 33, 253) -9.08%, rgb(122, 17, 255) 74.09%) repeat scroll 0% 0% / auto padding-box border-box");

                // Verify Logo
                Verifications.verifyElementIsVisible(vicariusSignUp.getLogo());

                // Verify Heading text
                Verifications.verifyStringContains(vicariusSignUp.getContentHeading().getText(),
                                "Start Your 14-day");
                Verifications.verifyStringContains(vicariusSignUp.getContentHeading().getText(),
                                "Free Trial");

        }

        @Test(description = "Sign up page option", priority = 2)
        @Description("Option visible on Sign Up page")
        public void VicariusOption() {

                // Verify header option text & link
                Verifications.verifyElementText(vicariusSignUp.getHeaderOptionText(), "Already have an account?");
                Verifications.verifyElementText(vicariusSignUp.getHeaderOptionLink(), "Login");
                Verifications.verifyString(vicariusSignUp.getHeaderOptionLink().getAttribute("href"),
                                SIGN_IN_URL);

                // Trigger hover effect
                UIActions.mouseHover(vicariusSignUp.getHeaderOptionLink());
                // TODO - Add assertion on header option link hover effect
        }

        @Test(description = "Sign up page features & FAQ", priority = 3)
        @Description("Features & FAQ visible on Sign Up page")
        public void VicariusFeaturesAndFAQ() {

                // TODO - Load texts from csv or json file
                String[][] features = { { "Vuln Discovery", "You can’t fix what you can’t find." },
                                { "Vuln Prioritization", "Focus on risks that have real potential for exploitation" },
                                { "Vuln Remediation", "Don’t just find your flaws, fix them." },
                                { "Automation", "Threats don’t take time off, but you can." } };

                // Verify features icons & texts visibility
                Verifications.verifyElementsAmountAndVisibility(vicariusSignUp.getFeaturesIcons(), features.length);
                Verifications.verifyElementsAmountAndVisibility(vicariusSignUp.getFeaturesHeaders(), features.length);
                Verifications.verifyElementsAmountAndVisibility(vicariusSignUp.getFeaturesTexts(), features.length);

                for (int i = 0; i < features.length; i++) {
                        WebElement featureIcon = vicariusSignUp.getFeaturesIcons().get(i);
                        WebElement featureHeader = vicariusSignUp.getFeaturesHeaders().get(i);
                        WebElement featureText = vicariusSignUp.getFeaturesTexts().get(i);

                        // Verify icon width & height
                        Verifications.verifyString(featureIcon.getAttribute("width"), "80");
                        Verifications.verifyString(featureIcon.getAttribute("height"), "80");

                        // Verify feature texts
                        Verifications.verifyString(featureHeader.getText(), features[i][0]);
                        Verifications.verifyString(featureText.getText(), features[i][1]);
                }

                // Verify FAQ link
                Verifications.verifyElementText(vicariusSignUp.getFrequentlyAskedQuestionsLink(),
                                "Frequently Asked Questions →");
                Verifications.verifyString(vicariusSignUp.getFrequentlyAskedQuestionsLink().getAttribute("href"),
                                CUSTOMER_PORTAL_URL + "/");
        }

        // TODO - Add test to verify notification disappears on its own
        @Test(description = "Empty Sign up", priority = 2)
        @Description("Verify Empty Sign Up errors & Inputs background color turns red")
        public void VicariusEmptySignUp() {

        }

        // Note - This test only showcases the use of mouse hover on two different
        // points in order to assert the cursor style has changed. It does not cover the
        // entire UX of the feature.
        @Test(description = "Mouse Cursor style", priority = 4)
        @Description("Verify Mouse Cursor style effect")
        public void VicariusMouseCursor() {

                // Move mouse to point A - causes style transform change
                UIActions.mouseHover(vicariusSignUp.getContentHeading(), SLEEP_TIMEOUT);
                String pointA = vicariusSignUp.getCursor().getAttribute("style");
                LOG.info("Cursor style: " + pointA);

                // Move mouse to point B - causes style transform change
                UIActions.mouseHover(vicariusSignUp.getLogo(), SLEEP_TIMEOUT);
                String pointB = vicariusSignUp.getCursor().getAttribute("style");
                LOG.info("Cursor style: " + pointB);

                // Verify cursor style has changed
                Verifications.verifyBoolean(pointA.equals(pointB), false);
        }

        @Test(description = "Chat Widget", priority = 4)
        @Description("Verify Chat Widget opens & closes")
        public void VicariusChatWidget() {

                // Switch to chat widget iframe
                CommonOps.switchToIFrame(CHAT_IFRAME);

                // Open & close chat
                WebFlows.openChat();
                WebFlows.closeChat();

        }

}
