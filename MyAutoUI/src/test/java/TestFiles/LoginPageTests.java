package TestFiles;

import actions.LoginPageActions;
import base.BaseTest;
import common.CommonTexts;
import dataProviders.LoginDateProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.ExecutionListener;

import java.lang.reflect.Method;
@Listeners(ExecutionListener.class)
@Feature("Login Test")
public class LoginPageTests extends BaseTest implements CommonTexts {

    LoginPageActions loginPageActions;

    @BeforeMethod(description = "Browser Initialized before class")
    public void Setup(Method m) {
        properties = initializeProperties();
        initializeBrowser();
        loginPageActions = new LoginPageActions(getDriver());
    }

    @Test(dataProvider = "user creds",dataProviderClass = LoginDateProvider.class)
    @Description("Testing User login Functionality")
    public void verifyLoginPickrr(String user, String pass) {
        loginPageActions
                .goToUrl(properties.getProperty("url"))
                .hoverCreateAndClickSignIn()
                .isLoginPage()
                .enterUserName(properties.getProperty(user))
                .clickContinue()
                .isPasswordPage()
                .enterPassword(properties.getProperty(pass))
                .clickSignIn()
                .validateLogin();
    }

}
