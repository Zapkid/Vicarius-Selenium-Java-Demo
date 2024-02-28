package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utilities.CommonOps;

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

}
