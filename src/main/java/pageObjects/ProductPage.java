package pageObjects;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = "header .logo")
    private WebElement headerLogo;

    @Step("Get Logo link element")
    public WebElement getHeaderLogo() {
        return headerLogo;
    }

    @FindBy(css = ".hero .title")
    private WebElement title;

    @Step("Get Title element")
    public WebElement getTitle() {
        return title;
    }

    @FindBy(css = ".hero h1")
    private WebElement heading;

    @Step("Get Heading element")
    public WebElement getHeading() {
        return heading;
    }

    @FindBy(css = "footer .logo")
    private WebElement footerLogo;

    @Step("Get Footer Logo element")
    public WebElement getFooterLogo() {
        return footerLogo;
    }

    @FindBy(css = "a[href='/sign/in']")
    private WebElement signInLink;

    @Step("Get Sign In Link element")
    public WebElement getSignInLink() {
        return signInLink;
    }

    @FindBy(css = "a[href='/sign/up']")
    private WebElement signUpLink;

    @Step("Get Sign Up Link element")
    public WebElement getSignUpLink() {
        return signUpLink;
    }

    @FindBy(css = ".hero-inner .btn")
    private WebElement watchDemo;

    @Step("Get Watch Demo element")
    public WebElement getWatchDemo() {
        return watchDemo;
    }

    @FindBy(css = ".playing-mode")
    private WebElement videoPlayingMode;

    @Step("Get Video Playing Mode element")
    public WebElement getVideoPlayingMode() {
        return videoPlayingMode;
    }

    @FindBy(css = ".btn-close")
    private WebElement videoClose;

    @Step("Get Video Close element")
    public WebElement getVideoClose() {
        return videoClose;
    }

    @FindBy(css = ".screen video")
    private WebElement vrxScreenVideo;

    @Step("Get Screen Video element")
    public WebElement getScreenVideo() {
        return vrxScreenVideo;
    }

    @FindBy(css = ".game-play")
    private WebElement playInvaders;

    @Step("Get Play Invaders element")
    public WebElement getPlayInvaders() {
        return playInvaders;
    }

    @FindBy(css = ".socials a[href='/careers']")
    private WebElement weAreHiring;

    @Step("Get We're Hiring element")
    public WebElement getWeAreHiring() {
        return weAreHiring;
    }

    @FindBy(css = "header .links .link-button")
    private List<WebElement> headerLinks;

    @Step("Get Header Links elements")
    public List<WebElement> getHeaderLinks() {
        return headerLinks;
    }

    @FindBy(css = ".download h3")
    private WebElement downloadTitle;

    @Step("Get Download PDF Title element")
    public WebElement getDownloadTitle() {
        return downloadTitle;
    }

    @FindBy(css = ".download .btn")
    private WebElement downloadButton;

    @Step("Get Download PDF Button element")
    public WebElement getDownloadButton() {
        return downloadButton;
    }

    @FindBy(css = "[id^='particles-container']:not(.particles-mobile)")
    private List<WebElement> particlesContainer;

    @Step("Get Particles Container elements")
    public List<WebElement> getParticlesContainer() {
        return particlesContainer;
    }
}