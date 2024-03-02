import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class ProductPageTests extends CommonOps {

        @Test(description = "Product page watch demo", priority = 1)
        @Description("Verify Product page watch demo button opens & plays the video")
        public void VicariusProductPageWatchDemo() {

                Verifications.verifyElementText(vicariusProduct.getWatchDemo(), "Watch Demo");
                UIActions.click(vicariusProduct.getWatchDemo(), SLEEP_TIMEOUT);

        }

        @Test(description = "Product page elements", priority = 2)
        @Description("Verify Product page elements")
        public void VicariusProductPageElements() {

                // Hover title for cool effect :)
                UIActions.mouseHover(vicariusProduct.getTitle());

                // Verify Header logo
                Verifications.verifyElementIsVisible(vicariusProduct.getHeaderLogo());

                // Verify Header links
                for (int i = 0; i < productPageHeaderLinks.length; i++) {
                        Verifications.verifyElementText(vicariusProduct.getHeaderLinks().get(i),
                                        productPageHeaderLinks[i]);
                }

                // Verify Header sign in & sign up
                Verifications.verifyElementText(vicariusProduct.getSignInLink(), "Login");
                Verifications.verifyString(vicariusProduct.getSignInLink().getAttribute("href"), SIGN_IN_URL);
                Verifications.verifyElementText(vicariusProduct.getSignUpLink(), "Start Free Trial");
                Verifications.verifyString(vicariusProduct.getSignUpLink().getAttribute("href"), SIGN_UP_URL);

                // Verify Heading and Watch Demo
                Verifications.verifyElementText(vicariusProduct.getHeading(), "vRx Overview");
                Verifications.verifyElementText(vicariusProduct.getWatchDemo(), "Watch Demo");

                // Verify Invaders game link
                Verifications.verifyElementIsVisible(vicariusProduct.getPlayInvaders());
                Verifications.verifyString(vicariusProduct.getPlayInvaders().getAttribute("href"), CVE_INVADERS_URL);

                // Verify Screen Video
                UIActions.scrollIntoView(vicariusProduct.getScreenVideo(), SLEEP_TIMEOUT);
                Verifications.verifyElementIsVisible(vicariusProduct.getScreenVideo());

                // Verify Download PDF
                // TODO - Verify PDF downloaded
                UIActions.scrollIntoView(vicariusProduct.getDownloadTitle(), SLEEP_TIMEOUT);
                Verifications.verifyElementText(vicariusProduct.getDownloadTitle(), "Download the PDF");
                Verifications.verifyElementText(vicariusProduct.getDownloadButton(), "Get It Now");

                // Verify Footer logo
                UIActions.scrollIntoView(vicariusProduct.getFooterLogo(), SLEEP_TIMEOUT);
                Verifications.verifyElementIsVisible(vicariusProduct.getFooterLogo());
                Verifications.verifyElementText(vicariusProduct.getWeAreHiring(), "We're hiring!");

        }

}
