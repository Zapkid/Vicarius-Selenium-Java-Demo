package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;

public class CommonOps extends Base {

    // Initiate Parameters from Suite XML
    @BeforeClass
    @Parameters({ "BrowserName", "URL", "Timeout" })
    // public void startSession(String BrowserName, String URL, Duration Timeout) {
        public void startSession() {
        // --- Init Params ---
        browserName = "chrome";
        url = "https://www.vicarius.io/sign/in";
        timeout = Duration.ofSeconds(10);

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
    }

    // Initiate Browser, Navigate to URL, Actions & Wait
    // Initiate Grafana Page Objects
    public static void initWeb() {
        if (browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if (browserName.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        setDriverTimeoutAndWait();
        driver.get(url);
        action = new Actions(driver);

        System.out.println("URL: " + url);

        ManagePages.initVicarius();
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