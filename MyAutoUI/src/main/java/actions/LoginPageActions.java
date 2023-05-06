package actions;

import base.BasePageActions;
import pages.HomePage;
import pages.LoginPage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class LoginPageActions extends BasePageActions {

    private final static Logger log = LogManager.getLogger(LoginPageActions.class.getName());

    public LoginPageActions(WebDriver driver) {
        super(driver);
    }

    public LoginPageActions loginToPickrr(String userName, String password) {
        log.info("Clicking Login Tab to land Pickrr's Login Page");
        click(LoginPage.loginLink);
        log.info("Trying to login Pickrr dashboard via.");
        Set<String> childWindows = driver.getWindowHandles();
        for (String window : childWindows){
            driver.switchTo().window(window);
        }
        inputText(LoginPage.emailIDInputBox,userName);
        inputText(LoginPage.passwordInputBox,password);
        click(LoginPage.loginBtn);
        return this;
    }

    public LoginPageActions verifyloginToPickrr() {
        log.info("Verifying login to pickrr is successfull");
        Assert.assertTrue(isCreateOrderPresent());
        // Code to reload the page
        String s= driver.getCurrentUrl();
        driver.get(s);
        return this;
    }

    public boolean isCreateOrderPresent(){
        return waitVisibility(HomePage.createOrderTopButton).isDisplayed();
    }

    public LoginPageActions goToUrl(String url) {
        log.info("Opening url :: "+ url+ " in browser");
        driver.get(url);
        return this;
    }

    public LoginPageActions hoverCreateAndClickSignIn(){
        hoverOn(HomePage.amz_signInLink);
        click(HomePage.amz_signInLink_Btn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public LoginPageActions enterUserName(String userName){
        inputText(LoginPage.amz_userInputbox,userName);
        return this;
    }

    public LoginPageActions enterPassword(String password){
        inputText(LoginPage.amz_passwordInputBox,password);
        return this;
    }

    public LoginPageActions clickContinue(){
        click(LoginPage.amz_continueButton);
        return this;
    }
    public LoginPageActions clickSignIn(){
        click(LoginPage.amz_SignInButton);
        return this;
    }

    public LoginPageActions isPasswordPage(){
        Assert.assertTrue(isElementPresent(LoginPage.amz_passwordInputBox));
        return this;
    }

    public LoginPageActions isLoginPage(){
        Assert.assertTrue(isElementPresent(LoginPage.amz_userInputbox));
        return this;
    }

    public LoginPageActions validateLogin(){
        Assert.assertTrue(isElementPresent(HomePage.amz_successSignInLocator));
        return this;
    }

}
