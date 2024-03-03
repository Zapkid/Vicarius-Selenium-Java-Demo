package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    // Web: Initiate Vicarius Webpage Objects
    public static void initVicariusPages() {
        vicariusBase = PageFactory.initElements(driver, pageObjects.BasePage.class);
        vicariusSignIn = PageFactory.initElements(driver, pageObjects.SignInPage.class);
        vicariusSignUp = PageFactory.initElements(driver, pageObjects.SignUpPage.class);
        vicariusProduct = PageFactory.initElements(driver, pageObjects.ProductPage.class);
    }

}
