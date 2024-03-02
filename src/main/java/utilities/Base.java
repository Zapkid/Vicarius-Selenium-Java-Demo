package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;

    protected static String browserName;
    protected static String url;
    protected static final long TIMEOUT = 10;
    protected static Duration timeout = Duration.ofSeconds(TIMEOUT);

    protected static pageObjects.SignInPage vicariusSignIn;
    protected static pageObjects.SignUpPage vicariusSignUp;
    protected static pageObjects.ProductPage vicariusProduct;

    protected static final int SLEEP_TIMEOUT = 1_000;

    // Vicarius
    protected static final String SIGN_IN_URL = "https://www.vicarius.io/sign/in";
    protected static final String SIGN_UP_URL = "https://www.vicarius.io/sign/up";
    protected static final String PRODUCT_URL = "https://www.vicarius.io/product";
    protected static final String CUSTOMER_PORTAL_URL = "https://customer-portal.vicarius.io";
    protected static final String CVE_INVADERS_URL = "https://www.vicarius.io/cve-invaders";

    protected static final String VALID_EMAIL = "admin@vicarius.io";
    protected static final String SUPPORT_EMAIL = "support@vicarius.io";

    protected static final String API_SIGN_IN_URL = "https://www.vicarius.io/api/v2/forms/signin";
    protected static final String API_SIGN_UP_URL = "https://www.vicarius.io/api/v2/forms/signup";

    protected static final String CHAT_IFRAME = "#hubspot-conversations-iframe";

    protected static final String[][] features = { { "Vuln Discovery", "You can’t fix what you can’t find." },
            { "Vuln Prioritization", "Focus on risks that have real potential for exploitation" },
            { "Vuln Remediation", "Don’t just find your flaws, fix them." },
            { "Automation", "Threats don’t take time off, but you can." } };

    protected static final String INPUT_COLOR = "rgba(76, 78, 240, 0.2)";
    protected static final String ERROR_RED_COLOR = "rgba(255, 104, 114, 0.15)";

    protected static final String[] passwordRules = { "8 - 30 characters", "Lowercase letter", "Uppercase letter",
            "Number", "Special character" };
    protected static final int PASSWORD_RULE_LENGTH_INDEX = 0;
    protected static final int PASSWORD_RULE_LOWERCASE_INDEX = 1;
    protected static final int PASSWORD_RULE_UPPERCASE_INDEX = 2;
    protected static final int PASSWORD_RULE_NUMBER_INDEX = 3;
    protected static final int PASSWORD_RULE_SPECIAL_CHAR_INDEX = 4;

    protected static final String[] productPageHeaderLinks = { "+ Product", "+ Solution", "Pricing", "+ Community",
            "+ Company", "Contact" };

}
