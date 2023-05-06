package actions;

import base.BasePageActions;
import pages.SignUpPage;
import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class SignUpPageActions extends BasePageActions {

    public SignUpPageActions(WebDriver driver) {
        super(driver);
    }

    public SignUpPageActions enterSignUpForm(String firstName, String lastName, String company, String emailID, String password ){
        inputText(SignUpPage.firstNameInputBox,firstName);
        inputText(SignUpPage.lastNameInputBox,lastName);
        inputText(SignUpPage.companyNameInputBox,company);
        inputText(SignUpPage.emailIDInputBox,emailID);
        inputText(SignUpPage.passwordInputBox,password);
        //click(termsAndConditionCheckBox);
        click(SignUpPage.submitFormButton);
        return this;
    }

    public SignUpPageActions verifySignUpForm(String exectedString){
        waitVisibility(SignUpPage.signUpMessageHolder);
        Assert.assertEquals(readText(SignUpPage.signUpMessageHolder),exectedString);
        return this;
    }

    public SignUpPageActions enterMobileForOTP(String mobile){
        inputText(SignUpPage.mobileNumberInputBox,mobile);
        click(SignUpPage.submitFormButton);
        return this;
    }

    public SignUpPageActions verifyForInvalidMobileInput(String expectedString){
        waitVisibility(SignUpPage.mobileErrorLabel);
        Assert.assertEquals(readText(SignUpPage.mobileErrorLabel),expectedString);
        return this;
    }

    public SignUpPageActions NavigateToSignUpPage(String url){
        Log.info("Opening url :: "+ url+ " in browser");
        driver.get(url);
        click(By.xpath("//a[text()='Free Sign Up']/parent ::li[@class=' orangeBtn nav-item desktop-only-cust peach-gradient ']"));
        Set<String> childWindows = driver.getWindowHandles();
        System.out.println(childWindows);
        for (String window : childWindows){
            driver.switchTo().window(window);
        }
        return this;
    }



}
