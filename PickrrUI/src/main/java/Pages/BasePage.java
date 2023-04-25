package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }
    public void click(WebElement by) {
        waitVisibility(by).click();
    }
    public void selectFromDropDown(By by,String visibleText) {
        Select select = new Select(waitVisibility(by));
        select.selectByVisibleText(visibleText);
    }
    public void selectFromDropDown(WebElement by,String visibleText) {
        Select select = new Select(waitVisibility(by));
        select.selectByVisibleText(visibleText);
    }

    //Write Text
    public void inputText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }
    public void inputText(WebElement by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
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
    public void hoverOn(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(waitVisibility(by)).build().perform();
    }

    public void hoverOn(WebElement by){
        Actions actions = new Actions(driver);
        actions.moveToElement(waitVisibility(by)).pause(Duration.ofSeconds(2)).build().perform();
    }

    //Navigate to Any Url
    public BasePage goToUrl(String url) {
        driver.get(url);
        return this;
    }

    public boolean textIsPresent(String text){
        return waitVisibility(By.xpath("//*[text()='####']".replace("####",text))).isDisplayed();
    }

}
