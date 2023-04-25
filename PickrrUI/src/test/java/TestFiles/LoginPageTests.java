package TestFiles;

import Actions.LoginPageActions;
import Base.BaseTest;
import Common.CommonTexts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTests extends BaseTest implements CommonTexts {

    LoginPageActions loginPageActions;
    Properties properties;

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    @BeforeClass(description = "Browser Initialized before class")
    public void init() {
        properties = initializeProperties();
        initializeBrowser();
        loginPageActions = new LoginPageActions(getDriver());
    }

    @Test
    public void verifyLoginPickrr() {
        loginPageActions
                .goToUrl(properties.getProperty("url"))
                .loginToPickrr("g.mangla911@gmail.com", "complex@1357")
                .isCreateOrderPresent();
    }

}
