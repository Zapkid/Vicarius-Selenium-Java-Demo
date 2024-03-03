import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// TODO - Add DDT to test on all applicable pages
@Listeners(utilities.Listeners.class)
public class OverlayTests extends CommonOps {

        @Test(description = "Chat Widget", priority = 4)
        @Description("Verify Chat Widget opens & closes")
        public void VicariusChatWidget() {

                // Switch to chat widget iframe
                CommonOps.switchToIFrame(CHAT_IFRAME);

                // Open & close chat
                CommonOps.openChat();
                CommonOps.closeChat();

        }

        // Note - This test only showcases the use of mouse hover on two different
        // points in order to assert the cursor style has changed. It does not cover the
        // entire UX of the feature.
        @Test(description = "Mouse Cursor style", priority = 4)
        @Description("Verify Mouse Cursor style effect")
        public void VicariusMouseCursor() {

                // Move mouse to point A - causes style transform change
                UIActions.hover(vicariusSignUp.getContentHeading(), SLEEP_TIMEOUT);
                String pointA = vicariusSignUp.getCursor().getAttribute("style");
                LOG.info("Cursor style: " + pointA);

                // Move mouse to point B - causes style transform change
                UIActions.hover(vicariusSignUp.getLogo(), SLEEP_TIMEOUT);
                String pointB = vicariusSignUp.getCursor().getAttribute("style");
                LOG.info("Cursor style: " + pointB);

                // Verify cursor style has changed
                Verifications.verifyBoolean(pointA.equals(pointB), false);
        }

}
