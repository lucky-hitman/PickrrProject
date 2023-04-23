package Tests;

import Actions.CreateOrderPageActions;
import Actions.HomepageActions;
import Actions.LoginPageActions;
import Base.BaseTest;
import Common.CommonTexts;
import Utils.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Properties;

public class CreateOrderPageTests extends BaseTest implements CommonTexts {

    Properties properties;
    CreateOrderPageActions createOrderPageActions;
    LoginPageActions loginPageActions;
    HomepageActions homepageActions;

    @BeforeMethod
    public void setUp(){
        properties = initializeProperties();
        initializeBrowser();
        createOrderPageActions = new CreateOrderPageActions(getDriver());
        loginPageActions = new LoginPageActions(getDriver());
        homepageActions = new HomepageActions(getDriver());

    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void createSingleOrder(){
        loginPageActions
                .goToUrl(properties.getProperty("url"))
                        .loginToPickrr("g.mangla911@gmail.com","complex@1357").verifyloginToPickrr();
        homepageActions
                .HoverCreateAndClickCreateOrder();
        createOrderPageActions
                .addCustomerDetails("TestAuto","9898898989","122002","Testing My World")
                .selectDefaultPickUpLocation()
                .selectNext()
                .enterItemDetails("Item1",1)
                .addCompleteOrderDetails(1.1, Arrays.asList(1.1,1.1,1.1),100.10,"","auto"+ TestUtils.generateRandomNumber())
                .selectNext()
                .reviewOrderDetails(100.10,null)
                .clickPlaceOrder();
    }

}
