package Tests;

import Actions.HomepageActions;
import Actions.LoginPageActions;
import Base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTests extends BaseTest {

    HomepageActions homepageActions;
    LoginPageActions loginPageActions;
    Properties properties;

    @BeforeMethod
    public void init(){
        properties = initializeProperties();
        initializeBrowser();
        homepageActions = new HomepageActions(getDriver());
        loginPageActions = new LoginPageActions(getDriver());
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void verifyNavigationToCreateOrderPage(){
        loginPageActions
                .goToUrl(properties.getProperty("url"))
                .loginToPickrr("g.mangla911@gmail.com","complex@1357")
                .verifyloginToPickrr().isCreateOrderPresent();

        homepageActions.HoverCreateAndClickCreateOrder();
    }
}
