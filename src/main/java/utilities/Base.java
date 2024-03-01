package utilities;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected static Actions action;

    protected static String browserName;
    protected static String url;
    protected static Duration timeout;

    protected static pageObjects.SignInPage vicariusSignIn;
    protected static pageObjects.SignUpPage vicariusSignUp;
    protected static pageObjects.ProductPage vicariusProduct;

    protected static Proxy seleniumProxy;

    public static final int SLEEP_TIMEOUT = 500;

    // Vicarius
    public static final String VALID_EMAIL = "admin@vicarius.io";
    public static final String API_SIGN_IN_URL = "https://www.vicarius.io/api/v2/forms/signin";
}
