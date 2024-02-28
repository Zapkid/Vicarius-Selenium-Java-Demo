package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;

public class CommonOps extends Base {

    // Initiate Parameters from Suite XML
    // @BeforeClass
    // @Parameters({ "BrowserName", "URL", "Timeout" })
    // public void startSession(String BrowserName, String URL, String Timeout) {
    // // --- Init Params ---
    // browserName = BrowserName;
    // url = URL;
    // try {
    // timeout = Duration.ofSeconds(Integer.parseInt(Timeout));
    // } catch (NumberFormatException e) {
    // System.out.println("Invalid integer input");
    // }

    // initWeb();
    // }

    // Close session
    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    // Start video recording before starting a test
    @BeforeMethod
    public void beforeMethod(Method method) {

        driver.get(url);

        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Initiate Browser, Navigate to URL, Actions & Wait
    public static void initWeb() {

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid Browser Type");
        }
        driver.manage().window().maximize();
        setDriverTimeoutAndWait();

        action = new Actions(driver);

        ManagePages.initVicariusPages();
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
        driver.manage().timeouts().implicitlyWait(timeout);
        wait = new WebDriverWait(driver, timeout);
    }
}