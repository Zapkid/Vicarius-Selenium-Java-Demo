package workflows;

import utilities.CommonOps;
import extensions.UIActions;
import extensions.Verifications;

public class WebFlows extends CommonOps {
    public static void signIn(String email) {
        UIActions.type(vicariusSignIn.getEmailInput(), email);
        LOG.info("Signing in user: " + email);
        Verifications.verifyElementText(vicariusSignIn.getSubmitButton(), "Login");
        UIActions.click(vicariusSignIn.getSubmitButton(), SLEEP_TIMEOUT);
    }
}
