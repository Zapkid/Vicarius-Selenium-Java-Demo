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
public class SignUpPageTests extends CommonOps {

        @Test(description = "Valid Sign up", priority = 1)
        @Description("Tests a valid sign up")
        public void VicariusValidSignUp() {

                WebFlows.signUp("Victor", "Wolf", "vwolf@pack.com", "WolfPack");

                // Verify Password inputs toggle visibility icon
                Verifications.verifyString(
                                getElementFollowingSibling(vicariusSignUp.getPasswordInput()).getAttribute("class"),
                                "toggle-visibility");
                Verifications.verifyString(getElementFollowingSibling(vicariusSignUp.getConfirmPasswordInput())
                                .getAttribute("class"), "toggle-visibility");

                // Verify submit button enabled & text
                Verifications.verifyBoolean(vicariusSignUp.getSubmitButton().isEnabled(), true);
                Verifications.verifyElementText(vicariusSignUp.getSubmitButton(), "Start Free 14-days Trial");

                // Type valid password
                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "aB3$12vw");

                // Type valid password on confirm password input field
                UIActions.waitAndType(vicariusSignUp.getConfirmPasswordInput(), "aB3$12vw");

                // Submit form
                UIActions.click(vicariusSignUp.getSubmitButton(), SLEEP_TIMEOUT);

                // Verify message icon visible
                Verifications.verifyElementIsVisible(vicariusSignUp.getMessageIcon());

                // Verify sign in API response
                Verifications.verifyApiResponse(API_SIGN_UP_URL, HttpResponseStatus.OK);

                // Verify Content text
                Verifications.verifyElementText(vicariusSignUp.getContentHeading(),
                                "Hooray!");
                Verifications.verifyElementText(getElementFollowingSibling(vicariusSignUp.getContentHeading()),
                                "Please check your email for verification link");

        }

        @Test(description = "Password Rules", priority = 2)
        @Description("Tests sign up password rules")
        public void VicariusPasswordRules() {

                WebFlows.signUp("Victor", "Wolf", "vwolf@pack.com", "WolfPack");

                // Trigger password help rules
                UIActions.click(vicariusSignUp.getPasswordInput(), SLEEP_TIMEOUT);
                UIActions.click(vicariusSignUp.getContentHeading(), SLEEP_TIMEOUT);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getPasswordInput()),
                                "background-color",
                                ERROR_RED_COLOR);

                // Verify Password help label text
                Verifications.verifyElementText(vicariusSignUp.getPasswordHelpLabel(), "Your password must contain:");

                for (int i = 0; i < passwordRules.length; i++) {
                        // Verify Password help rules
                        Verifications.verifyElementText(
                                        vicariusSignUp.getPasswordHelpRules().get(i),
                                        passwordRules[i]);

                        // Verify Password help rules have is-invalid class
                        Verifications.verifyString(
                                        vicariusSignUp.getPasswordHelpRules().get(i).getAttribute("class"),
                                        "tag is-invalid");
                }

                // TODO - Refactor for better readability
                // Verify password rules validated
                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "a");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LENGTH_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LOWERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_UPPERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_NUMBER_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_SPECIAL_CHAR_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");

                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "B");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LENGTH_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LOWERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");

                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_UPPERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_NUMBER_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_SPECIAL_CHAR_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");

                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "3");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LENGTH_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LOWERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");

                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_UPPERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_NUMBER_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_SPECIAL_CHAR_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");

                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "$");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LENGTH_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LOWERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");

                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_UPPERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_NUMBER_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_SPECIAL_CHAR_INDEX)
                                                .getAttribute("class"),
                                "tag");

                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "abc");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LENGTH_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LOWERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");

                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_UPPERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_NUMBER_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_SPECIAL_CHAR_INDEX)
                                                .getAttribute("class"),
                                "tag");

                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "d");
                Verifications.verifyElementNotFound(".password-help");

                // Increasing entered password to max allowed length
                for (int i = 0; i < 22; i++) {
                        UIActions.type(vicariusSignUp.getPasswordInput(), "e");
                }
                Verifications.verifyElementNotFound(".password-help");

                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "F");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LENGTH_INDEX)
                                                .getAttribute("class"),
                                "tag is-invalid");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_LOWERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");

                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_UPPERCASE_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_NUMBER_INDEX)
                                                .getAttribute("class"),
                                "tag");
                Verifications.verifyString(
                                vicariusSignUp.getPasswordHelpRules().get(PASSWORD_RULE_SPECIAL_CHAR_INDEX)
                                                .getAttribute("class"),
                                "tag");

        }

        @Test(description = "Password Mismatch", priority = 2)
        @Description("Tests sign up password mismatch")
        public void VicariusPasswordMismatch() {

                WebFlows.signUp("Victor", "Wolf", "vwolf@pack.com", "WolfPack");

                // Trigger password help rules
                UIActions.click(vicariusSignUp.getPasswordInput(), SLEEP_TIMEOUT);
                UIActions.click(vicariusSignUp.getContentHeading(), SLEEP_TIMEOUT);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getPasswordInput()),
                                "background-color",
                                ERROR_RED_COLOR);

                // Type valid password
                UIActions.waitAndType(vicariusSignUp.getPasswordInput(), "aB3$12vw");

                // Type valid but mismatched password on confirm password input field
                UIActions.waitAndType(vicariusSignUp.getConfirmPasswordInput(), "wv21$3Ba");

                // Submit form
                UIActions.click(vicariusSignUp.getSubmitButton(), SLEEP_TIMEOUT);

                // Verify mismatch error on confirm password input field
                Verifications.verifyElementText(driver.findElement(By.cssSelector(".input-field.is-error.has-errors")),
                                "Passwords do not match.");

        }

        // TODO - Add tests to verify each input turns red when others are valid
        @Test(description = "Empty Sign up", priority = 2)
        @Description("Verify Empty Sign Up errors & Inputs background color turns red")
        public void VicariusEmptySignUp() {
                // Click on submit button
                UIActions.click(vicariusSignUp.getSubmitButton(), SLEEP_TIMEOUT);

                // Verify inputs background-color changed to red
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getFirstNameInput()),
                                "background-color",
                                ERROR_RED_COLOR);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getLastNameInput()),
                                "background-color",
                                ERROR_RED_COLOR);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getEmailInput()),
                                "background-color",
                                ERROR_RED_COLOR);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getCompanyInput()),
                                "background-color",
                                ERROR_RED_COLOR);
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

                // Verify Heading & Subtitle text
                Verifications.verifyStringContains(vicariusSignUp.getContentHeading().getText(),
                                "Start Your 14-day");
                Verifications.verifyStringContains(vicariusSignUp.getContentHeading().getText(),
                                "Free Trial");
                Verifications.verifyStringContains(vicariusSignUp.getContentSubtitle().getText(),
                                "Deploy in minutes. No credit card. No commitment.");

                // Verify Sign up inputs
                Verifications.verifyElementIsVisible(vicariusSignUp.getFirstNameInput());
                Verifications.verifyElementIsVisible(vicariusSignUp.getLastNameInput());
                Verifications.verifyElementIsVisible(vicariusSignUp.getEmailInput());
                Verifications.verifyElementIsVisible(vicariusSignUp.getCompanyInput());

                // Verify inputs initial background-color
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getFirstNameInput()),
                                "background-color",
                                INPUT_COLOR);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getLastNameInput()),
                                "background-color",
                                INPUT_COLOR);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getEmailInput()),
                                "background-color",
                                INPUT_COLOR);
                Verifications.verifyElementCss(getElementParent(vicariusSignUp.getCompanyInput()),
                                "background-color",
                                INPUT_COLOR);

                // Verify Consent
                Verifications.verifyElementIsVisible(vicariusSignUp.getConsentIcon());
                Verifications.verifyElementText(vicariusSignUp.getConsentText(),
                                "By submitting this form, you consent to be contacted about Vicarius product.");

                // Verify submit button enabled & text
                Verifications.verifyBoolean(vicariusSignUp.getSubmitButton().isEnabled(), true);
                Verifications.verifyElementText(vicariusSignUp.getSubmitButton(), "Continue");

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
                UIActions.hover(vicariusSignUp.getHeaderOptionLink());
                // TODO - Add assertion on header option link hover effect
        }

        @Test(description = "Sign up page features & FAQ", priority = 3)
        @Description("Features & FAQ visible on Sign Up page")
        public void VicariusFeaturesAndFAQ() {

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

}
