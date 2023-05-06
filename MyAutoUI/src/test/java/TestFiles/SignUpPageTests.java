package TestFiles;

import actions.SignUpPageActions;
import base.BaseTest;
import common.CommonTexts;
import utils.common.CommonUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.ExecutionListener;

@Listeners(value = ExecutionListener.class)
public class SignUpPageTests extends BaseTest  implements CommonTexts {

    SignUpPageActions signUpPageActions;
    @BeforeMethod
    public void init(){
        properties = initializeProperties();
        initializeBrowser();
        signUpPageActions = new SignUpPageActions(getDriver());
    }

    @Test(priority = 0, description = "Verifying User Sign-Up For Free functionality ")
    public void verifyUserSignUpForFree() throws InterruptedException {
        signUpPageActions.NavigateToSignUpPage(properties.getProperty("url")).
                enterSignUpForm("Deva","Test","Nothing","kooks"+ CommonUtils.generateRandomNumber() +"@bbshc.com","kuchBhi@123").
                    verifySignUpForm(signUpSuccessMessage1);
    }

    @Test(priority = 1, description = "Verifying User Sign-Up For Mobile functionality ")
    public void verifyMobile(){
        signUpPageActions.NavigateToSignUpPage(properties.getProperty("url")).enterSignUpForm("Deva","Test","Nothing","kooks"+ CommonUtils.generateRandomNumber() +"@gmail.com","kuchBhi@123").
                enterMobileForOTP("10"+ CommonUtils.generateRandomNumber()).verifyForInvalidMobileInput(invalidMobileEnteredText);
    }

}
