package actions;

import base.BasePageActions;
import common.CommonTexts;
import pages.HomePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import static utils.common.CommonUtils.*;


public class HomepageActions extends BasePageActions implements CommonTexts {

    private final static Logger log = LogManager.getLogger(HomepageActions.class.getName());

    public HomepageActions(WebDriver driver) {
        super(driver);
    }

    public HomepageActions HoverCreateAndClickCreateOrder(){
        hoverOn(HomePage.createOrderTopButton);
        click(HomePage.createSingleOrderlink);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public HomepageActions HoverCreateAndClickSignIn(){
        hoverOn(HomePage.amz_signInLink);
        click(HomePage.amz_signInLink_Btn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public HomepageActions goToUrl(String url) {
        log.info("Opening url :: "+ url+ " in browser");
        driver.get(url);
        return this;
    }

    public HomepageActions assertPageTitle(String expectedTitle){
        String title= driver.getTitle();
        Assert.assertEquals(title,expectedTitle);
        return this;
    }

    public HomepageActions validateUserNameIsPresent(String userName){
        String user = readText(HomePage.amz_successSignInLocator);
            Assert.assertTrue(user.contains(validUserName));
            return this;
    }

    public HomepageActions validateSearchOptionIsPresent(){
        Assert.assertTrue(isElementPresent(HomePage.amz_searchBarLocator));
        return this;
    }

    public HomepageActions selectAnyProductFromTopDealsCarousel(){
        scrollToElement(HomePage.amz_anyProductFromDealsLocator);
        Assert.assertTrue(isElementPresent(HomePage.amz_anyProductFromDealsLocator));
        click(HomePage.amz_anyProductFromDealsLocator);
        return this;
    }

    public HomepageActions verifyAllLinksAreClickable() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("No of links Found on page = "+ allLinks.size());
        for (WebElement a : allLinks) {
                String url= a.getAttribute("href");
                verifyLinks(url);
            }
        return this;
        }

}
