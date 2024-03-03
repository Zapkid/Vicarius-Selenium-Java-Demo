import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class ProductPageTests extends CommonOps {

        @Test(description = "Product page elements", priority = 2)
        @Description("Verify Product page elements")
        public void VicariusProductPageElements() {

                // Hover title for cool effect :)
                UIActions.hover(vicariusProduct.getTitle());

                // Verify Header logo
                Verifications.verifyElementIsVisible(vicariusProduct.getHeaderLogo());

                // Verify Header links texts
                for (int i = 0; i < productPageHeaderLinks.length; i++) {
                        WebElement headerLink = vicariusProduct.getHeaderLinks().get(i);

                        Verifications.verifyElementText(headerLink,
                                        productPageHeaderLinks[i]);

                        // Verify sub navigation on header link hover
                        if (productPageHeaderLinks[i].startsWith("+")) {
                                UIActions.hover(headerLink, SLEEP_TIMEOUT);
                                Verifications.verifyElementIsVisible(vicariusProduct.getSubNav());
                        }
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
                // TODO - Add test: Verify PDF downloaded
                UIActions.scrollIntoView(vicariusProduct.getDownloadTitle(), SLEEP_TIMEOUT);
                Verifications.verifyElementText(vicariusProduct.getDownloadTitle(), "Download the PDF");
                Verifications.verifyElementText(vicariusProduct.getDownloadButton(), "Get It Now");

                // Verify Particles Containers
                for (int i = 0; i < vicariusProduct.getParticlesContainer().size(); i++) {
                        WebElement particlesContainer = vicariusProduct.getParticlesContainer().get(i);
                        UIActions.scrollIntoView(particlesContainer, SLEEP_TIMEOUT);
                        UIActions.hover(particlesContainer, SLEEP_TIMEOUT);
                        Verifications.verifyElementIsVisible(particlesContainer);
                }

                // Verify Footer logo
                UIActions.scrollIntoView(vicariusProduct.getFooterLogo(), SLEEP_TIMEOUT);
                Verifications.verifyElementIsVisible(vicariusProduct.getFooterLogo());
                Verifications.verifyElementText(vicariusProduct.getWeAreHiring(), "We're hiring!");

        }

        @Test(description = "Product page watch demo", priority = 1)
        @Description("Verify Product page watch demo button opens & plays the video")
        public void VicariusProductPageWatchDemo() {

                Verifications.verifyElementText(vicariusProduct.getWatchDemo(), "Watch Demo");
                UIActions.click(vicariusProduct.getWatchDemo(), SLEEP_TIMEOUT);

                // Switch to video iframe
                CommonOps.switchToIFrame(VIDEO_IFRAME);

                // Verify video is playing
                Verifications.verifyElementIsVisible(vicariusProduct.getVideoPlayingMode());

                // TODO - Fix close video

                // // Verify close video
                // UIActions.mouseHover(vicariusProduct.getVideoClose(), SLEEP_TIMEOUT);
                // UIActions.click(vicariusProduct.getVideoClose(), SLEEP_TIMEOUT);

                // // Switch back to default iframe
                // CommonOps.switchToDefaultIFrame();

                // // Verify video closed
                // Verifications.verifyElementIsVisible(vicariusProduct.getWatchDemo());
                // Verifications.verifyElementNotFound(VIDEO_IFRAME);
        }

}
