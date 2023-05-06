package base;

import org.openqa.selenium.JavascriptExecutor;
import reporting.Reporter;
import com.aventstack.extentreports.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Boolean.TRUE;

public class BasePageActions {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;


    private final static Logger log = LogManager.getLogger(BasePageActions.class.getName());

    //Constructor
    public BasePageActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;

    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
        Reporter.getExtentTest().log(Status.INFO, "Element clicked :: " + by);
        log.info("Element clicked :: " + by);
    }

    public void click(WebElement by) {
        waitVisibility(by).click();
    }

    public void selectFromDropDown(By by, String visibleText) {
        Select select = new Select(waitVisibility(by));
        select.selectByVisibleText(visibleText);
    }

    public void selectFromDropDown(WebElement by, String visibleText) {
        Select select = new Select(waitVisibility(by));
        select.selectByVisibleText(visibleText);
    }

    //Write Text
    public void inputText(By by, String text) {
        waitVisibility(by).sendKeys(text);
        Reporter.getExtentTest().log(Status.INFO, "Filled text :: " + text + " in " + by);
        log.info("Filled text :: " + text + " in " + by);
    }

    public void inputText(WebElement by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        Reporter.getExtentTest().log(Status.INFO, "Read text from :: " + by);
        log.info("Read text from :: " + by);
        return waitVisibility(by).getText();

    }

    public String readText(WebElement by) {
        return waitVisibility(by).getText();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitVisibility(WebElement by) {
        return wait.until(ExpectedConditions.visibilityOf(by));
    }

    // HOVER On element
    public void hoverOn(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitVisibility(by)).build().perform();
    }

    public void hoverOn(WebElement by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitVisibility(by)).pause(Duration.ofSeconds(2)).build().perform();
    }

    //Navigate to Any Url
    public BasePageActions goToUrl(String url) {
        driver.get(url);
        return this;
    }

    public boolean textIsPresent(String text) {
        boolean flag = waitVisibility(By.xpath("//*[text()='####']".replace("####", text))).isDisplayed();
        if (flag == TRUE) {
            Reporter.getExtentTest().log(Status.INFO, "Text :: '" + text + "' Is Present");
            log.info("Text :: '" + text + "' Is Present");
        } else {
            Reporter.getExtentTest().log(Status.INFO, "Text :: '" + text + "' NOT FOUND!!!!!!!");
            log.info("Text :: '" + text + "' NOT FOUND!!!!!!!");
        }
        return flag;
    }

    public boolean isElementPresent(By by) {
        boolean flag = waitVisibility(by).isDisplayed();
        if (flag == TRUE) {
            Reporter.getExtentTest().log(Status.INFO, "Element :: '" + by + "' Is Present");
            log.info("Element :: '" + by + "' Is Present");
        } else {
            Reporter.getExtentTest().log(Status.INFO, "Element :: '" + by + "' NOT FOUND!!!!!!!");
            log.info("Element :: '" + by + "' NOT FOUND!!!!!!!");
        }
        return flag;
    }

    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
