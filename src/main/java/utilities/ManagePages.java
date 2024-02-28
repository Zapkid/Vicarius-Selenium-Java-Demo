package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    // Web: Initiate Grafana Webpage Objects
    public static void initVicarius() {
        vicariusSignIn = PageFactory.initElements(driver, pageObjects.SignInPage.class);
        vicariusSignUp = PageFactory.initElements(driver, pageObjects.SignUpPage.class);
    }

}
