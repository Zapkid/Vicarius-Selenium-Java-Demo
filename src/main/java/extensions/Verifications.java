package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify text in element")
    public static void verifyElementText(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expected);
    }

    @Step("Verify element is visible")
    public static void verifyElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), "Element is not visible");
    }

    @Step("Verify String")
    public static void verifyString(String actual, String exp) {
        assertEquals(actual, exp);
    }

    @Step("Verify String Contains")
    public static void verifyStringContains(String actual, String exp) {
        assertTrue(actual.contains(exp));
    }

    @Step("Verify Number Of Elements")
    public static void verifyNumberOfElements(List<WebElement> elements, int expected) {
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        assertEquals(elements.size(), expected);
    }

    @Step("Verify Response status code")
     public static void verifyResponseStatus(String Url, String statusCode) {
        LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry le : les) {
            if (le.getMessage().contains(Url)
                    && le.getMessage().contains("status")) {
                try {
                    // Parse the JSON string
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode jsonNode = objectMapper.readTree(le.getMessage());

                    // Navigate through the JSON structure to extract the desired value
                    String status = jsonNode.path("message").path("params").path("response").path("status").asText();

                    Verifications.verifyString(status, statusCode);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
