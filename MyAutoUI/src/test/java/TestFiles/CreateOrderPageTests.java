package TestFiles;

import actions.CreateOrderPageActions;
import actions.HomepageActions;
import actions.LoginPageActions;
import base.BaseTest;
import common.CommonTexts;
import utils.common.CommonUtils;
import org.testng.annotations.*;

import java.util.Arrays;

public class CreateOrderPageTests extends BaseTest implements CommonTexts {

    CreateOrderPageActions createOrderPageActions;
    LoginPageActions loginPageActions;
    HomepageActions homepageActions;

    @BeforeClass
    public void setUp(){
        properties = initializeProperties();
        initializeBrowser();
        createOrderPageActions = new CreateOrderPageActions(getDriver());
        loginPageActions = new LoginPageActions(getDriver());
        homepageActions = new HomepageActions(getDriver());

    }

    @AfterClass
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
//        createOrderPageActions
//                .addCustomerDetails("TestAuto","9898898989","122002","Testing My World")
//                .selectDefaultPickUpLocation()
//                .selectNext()
//                .enterItemDetails("Item1",1)
//                .addCompleteOrderDetails(1.1, Arrays.asList(1.1,1.1,1.1),100.10,"","auto"+ TestUtils.generateRandomNumber())
//                .selectNext()
//                .reviewOrderDetails(100.10,null)
//                .clickPlaceOrder().fetchClientOrderID();
//                System.out.println(createOrderPageActions.getClientOrderID());
    }
    @Test(dependsOnMethods = "createSingleOrder")
    public void createSingleOrderPartTwo() {
        createOrderPageActions
                .addCustomerDetails("TestAuto", "9898898989", "122002", "Testing My World")
                .selectDefaultPickUpLocation()
                .selectNext()
                .enterItemDetails("Item1", 1)
                .addCompleteOrderDetails(1.1, Arrays.asList(1.1, 1.1, 1.1), 100.10, "", "auto" + CommonUtils.generateRandomNumber())
                .selectNext()
                .reviewOrderDetails(100.10, null)
                .clickPlaceOrder().fetchClientOrderID();
        System.out.println(createOrderPageActions.getClientOrderID());
    }

}
