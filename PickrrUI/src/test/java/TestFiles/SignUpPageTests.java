package TestFiles;

import Actions.SignUpPageActions;
import Base.BaseTest;
import Common.CommonTexts;
import Utils.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class SignUpPageTests extends BaseTest  implements CommonTexts {

    SignUpPageActions signUpPageActions;
    Properties properties;
    @BeforeMethod
    public void init(){
        properties = initializeProperties();
        initializeBrowser();
        signUpPageActions = new SignUpPageActions(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @Test(priority = 0, description = "Verifying User Sign-Up For Free functionality ")
    public void verifyUserSignUpForFree() throws InterruptedException {
        signUpPageActions.NavigateToSignUpPage(properties.getProperty("url")).
                enterSignUpForm("Deva","Test","Nothing","kooks"+ TestUtils.generateRandomNumber() +"@bbshc.com","kuchBhi@123").
                    verifySignUpForm(signUpSuccessMessage1);
        Thread.sleep(5000);
    }

    @Test(priority = 1, description = "Verifying User Sign-Up For Mobile functionality ")
    public void verifyMobile(){
        signUpPageActions.NavigateToSignUpPage(properties.getProperty("url")).enterSignUpForm("Deva","Test","Nothing","kooks"+ TestUtils.generateRandomNumber() +"@gmail.com","kuchBhi@123").
                enterMobileForOTP(TestUtils.generateRandomNumber()).verifyForInvalidMobileInput(invalidMobileEnteredText);
    }

}
