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
}
