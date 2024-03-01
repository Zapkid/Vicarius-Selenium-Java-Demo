package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;

    protected static String browserName;
    protected static String url;
    public static final long TIMEOUT = 10;
    protected static Duration timeout = Duration.ofSeconds(TIMEOUT);

    protected static pageObjects.SignInPage vicariusSignIn;
    protected static pageObjects.SignUpPage vicariusSignUp;
    protected static pageObjects.ProductPage vicariusProduct;

    public static final int SLEEP_TIMEOUT = 500;

    // Vicarius
    public static final String SIGN_IN_URL = "https://www.vicarius.io/sign/in";
    public static final String SIGN_UP_URL = "https://www.vicarius.io/sign/up";
    public static final String CUSTOMER_PORTAL_URL = "https://customer-portal.vicarius.io";
    public static final String VALID_EMAIL = "admin@vicarius.io";
    public static final String SUPPORT_EMAIL = "support@vicarius.io";
    public static final String API_SIGN_IN_URL = "https://www.vicarius.io/api/v2/forms/signin";
    public static final String API_SIGN_UP_URL = "https://www.vicarius.io/api/v2/forms/signup";
    public static final String CHAT_IFRAME = "#hubspot-conversations-iframe";

    public static final String[][] features = { { "Vuln Discovery", "You can’t fix what you can’t find." },
            { "Vuln Prioritization", "Focus on risks that have real potential for exploitation" },
            { "Vuln Remediation", "Don’t just find your flaws, fix them." },
            { "Automation", "Threats don’t take time off, but you can." } };
}
