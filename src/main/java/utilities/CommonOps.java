package utilities;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import extensions.UIActions;
import extensions.Verifications;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Level;

public class CommonOps extends Base {

    public static final Logger LOG = LoggerFactory.getLogger(CommonOps.class);

    // Initiate Parameters from Suite XML
    @BeforeClass
    @Parameters({ "BrowserName", "URL", "timeout" })
    public void startSession(String BrowserName, String URL, String timeout) {
        browserName = BrowserName;
        url = URL;
        try {
            timeoutDuration = Duration.ofSeconds(Integer.parseInt(timeout));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        initWeb();
    }

    // Close session
    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    // Start video recording before starting a test
    @BeforeMethod
    public void beforeMethod(Method method) {

        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.get(url);

    }

    // Initiate Browser, Navigate to URL, Actions & Wait
    public static void initWeb() {
        if (browserName.equalsIgnoreCase("chrome")) {
            initChrome();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            initFireFox();
        } else if (browserName.equalsIgnoreCase("edge")) {
            initEdge();
        } else {
            throw new RuntimeException("Invalid Browser Type");
        }

        driver.manage().window().maximize();
        setDriverTimeoutAndWait();
        action = new Actions(driver);

        ManagePages.initVicariusPages();
    }

    private static void initEdge() {
        EdgeOptions options = new EdgeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        driver = new EdgeDriver();
    }

    private static void initFireFox() {
        FirefoxOptions options = new FirefoxOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        driver = new FirefoxDriver();
    }

    private static void initChrome() {
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        driver = new ChromeDriver(options);
    }

    // Take a screenshot for Allure report & save a png file
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveScreenshot(String desc, String format) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp timeStamp = new Timestamp(time);
        String timeString = timeStamp.toString();
        timeString = timeString.substring(11).replace(".", ":").replace(":", "_");
        byte[] imgBytes = new byte[0];
        imgBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        try {
            FileUtils.writeByteArrayToFile(new File("./screenshots/" + timeString + " - " + desc + "." + format),
                    imgBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgBytes;
    }

    public static void setDriverTimeoutAndWait() {
        driver.manage().timeouts().implicitlyWait(timeoutDuration);
        wait = new WebDriverWait(driver, timeoutDuration);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Step("Switch to iframe")
    public static void switchToIFrame(String iframeCssSelector) {
        WebElement iframe = driver.findElement(By.cssSelector(iframeCssSelector));
        Verifications.verifyElementIsVisible(iframe);
        LOG.info("Switching to iframe: " + iframeCssSelector);
        driver.switchTo().frame(iframe);
    }

    @Step("Switch to default iframe")
    public static void switchToDefaultIFrame() {
        driver.switchTo().defaultContent();
        LOG.info("Switching back to default iframe.");
    }

    @Step("Get element parent")
    public static WebElement getElementParent(WebElement element) {
        return element.findElement(By.xpath("parent::*"));
    }

    @Step("Get element following-sibling")
    public static WebElement getElementFollowingSibling(WebElement element) {
        return element.findElement(By.xpath("following-sibling::*"));
    }

    @Step("Open Chat")
    public static void openChat() {
        UIActions.click(vicariusBase.getChatWidgetLauncher(), SLEEP_TIMEOUT);
        Verifications.verifyElementIsVisible(vicariusBase.getLiveChatWidget());
        LOG.info("Chat Widget opened successfully.");
    }

    @Step("Close Chat")
    public static void closeChat() {
        UIActions.click(vicariusBase.getChatWidgetLauncher(), SLEEP_TIMEOUT);
        Verifications.verifyElementNotFound("#live-chat-widget");
        LOG.info("Chat Widget closed successfully.");
    }
}